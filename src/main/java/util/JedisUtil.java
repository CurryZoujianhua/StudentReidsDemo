package main.java.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class JedisUtil {

    //声明静态的JedisPool属性
    private static JedisPool jedisPool = null;
    //静态块
    static {
        /*//获取inputStream流 读取redis.properties配置文件
        //InputStream inputStream = MyRedisPool.class.getClassLoader().
        ///        getResourceAsStream("redis.properties");
        //Properties集合获取配置文件中的配置属性
        //Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //创建JedisPoolConfig连接池配置对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
       //设置最大连接数
        poolConfig.setMaxTotal(50);
        //设置最大闲置数
        poolConfig.setMaxIdle(20);
        //设置最小闲置数
        poolConfig.setMinIdle(10);
        //创建redis连接池，把配置对象给她
        jedisPool = new JedisPool(poolConfig, "129.204.163.77",6379);
    }

    /**
     * 得到redis操作资源对象方法
     * @return Jedis操作资源对象
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
