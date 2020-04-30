package Dao;
import com.alibaba.fastjson.JSON;
import  entity.Student;
import jdk.jfr.events.ExceptionThrownEvent;
import redis.clients.jedis.Jedis;
import java.util.List;
import static main.java.util.JedisUtil.getJedis;

public class StuDao {

    //根据 id 获取 学生信息
    public Student getStuById(String id){
        //获取redis连接
        Jedis jedis = getJedis();
        jedis.auth("zoujianhua");
        //从redis获取学生信息
        Student student = null;
        //根据id从hash中获取具体的一个学生信息
        List<String> string =  jedis.hmget("student",id);
        for (String stu:string ) {
            //将字符串反序列化为学生对象
             student = JSON.parseObject(stu,Student.class);
        }
        return  student;
    }

    //根据ID修改信息
    public boolean updateInfo(Student student){
        Jedis jedis = getJedis();
        jedis.auth("zoujianhua");
        //修改
         //将studeng序列化为字符串
       String stuStr =   JSON.toJSONString(student);
       try {
           //修改hash
           jedis.hset("student", student.getId(), stuStr);
           //修改zset
           jedis.zrem("stuAvg",student.getId());
           jedis.zadd("stuAvg", student.getAvgscore(), student.getId());
       }catch (Exception e){
           e.printStackTrace();
       }
     return  true;
    }

    //根据ID删除信息
    public  boolean deleteInfo(String Id){
        Jedis jedis = getJedis();
        jedis.auth("zoujianhua");
        try {
            jedis.hdel("student", Id);
            jedis.zrem("stuAvg", Id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  true;
    }

    //新增学生操作
    public boolean addStu(Student student){
        Jedis jedis = getJedis();
        jedis.auth("zoujianhua");
        try {
            //将studeng序列化为字符串
            String stuStr =   JSON.toJSONString(student);
            jedis.hset("student", student.getId(), stuStr);
            jedis.zadd("stuAvg", student.getAvgscore(), student.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;

    }



}
