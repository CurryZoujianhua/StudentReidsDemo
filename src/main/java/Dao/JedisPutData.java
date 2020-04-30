 package Dao;

import com.alibaba.fastjson.JSON;
import entity.Student;
import main.java.util.IDUtil;
import main.java.util.JedisUtil;
import main.java.util.NameGenerate;
import redis.clients.jedis.Jedis;
import java.util.*;

import static main.java.util.NameGenerate.randomDate;

/**
 *
 * 添加原始数据到redis中
 */

public class JedisPutData {

    public static void main(String[] args){
        Jedis jedis = JedisUtil.getJedis();
        jedis.auth("zoujianhua");
        setDataToRedis(jedis);

        // System.out.println(getStudentListFromRedis(jedis));
        //setDataToRedis(jedis);

       /* List<Student> list =getStudentListFromRedis(jedis);
        for (Student s:list) {
            System.out.println(s.getName()+" "+s.getAvgscore());
        }*/

    }

    //获取redis数据
    public static  List<Student> getStudentListFromRedis(int start, int end){
        Jedis jedis = JedisUtil.getJedis();
        jedis.auth("zoujianhua");
         List list = new ArrayList();
         //从zset中获取倒叙数据  默认0 -9
         Set<String> set =  jedis.zrevrange("stuAvg", start, end);
        for (String id:set) {
             //根据id从hash中获取具体的一个学生信息
            List<String> string =  jedis.hmget("student",id);
            for (String stu:string ) {
                     //将字符串反序列化为学生对象
                Student student = JSON.parseObject(stu,Student.class);
                list.add(student);
            }

        }
        return  list;

    }

    //设置默认数据到redis
    public static  void setDataToRedis(Jedis jedis){
        /** 生成学生数据 **/
        HashMap<String,String> map = new HashMap<>();
        HashMap map_set = new HashMap<>();
        for (int i = 0; i <50 ; i++) {
            Student student = new Student();
            student.setId(IDUtil.getGUID());
            student.setBirthday(randomDate("1990-01-01","2005-01-01"));
            student.setAvgscore(i+10);
            student.setDescription(i+"zoujianhua");
            student.setName(NameGenerate.getStringRandom(6));
            map.put(student.getId(), JSON.toJSONString(student));
            //同时插入zset
            map_set.put(student.getId(),Double.valueOf(student.getAvgscore()));
        }
        jedis.hmset("student",map);
        jedis.zadd("stuAvg",map_set);

    }


}




