package main.java.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class NameGenerate {
    //生成随机用户名，数字和字母组成,
     public static  String getStringRandom(int length) {

             String val = "";
             Random random = new Random();
             for(int i = 0; i < length; i++) {
                 String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
                         //输出字母还是数字
                 if( "char".equalsIgnoreCase(charOrNum) ) {
                       //输出是大写字母还是小写字母
                     int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                      val += (char)(random.nextInt(26) + temp);
                    } else if( "num".equalsIgnoreCase(charOrNum) ) {
                             val += String.valueOf(random.nextInt(10));
                       }
                   }
             return val;
      }

    /**
     * 获取随机日期
     *
     * @param beginDate
     *            起始日期，格式为：yyyy-MM-dd
     * @param endDate
     *            结束日期，格式为：yyyy-MM-dd
     * @return
     */

    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }



}
