package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 将指定字符串转换成日期
     *
     * @param date
     *            String 日期字符串
     * @param datePattern
     *            String 日期格式
     * @return Date
     */
    public static java.util.Date getFormatDate(String date, String datePattern) {
        SimpleDateFormat sd = new SimpleDateFormat(datePattern);
        return sd.parse(date, new java.text.ParsePosition(0));
    }


    /**
     * 将指定日期对象转换成格式化字符串
     *
     * @param date
     *            Date XML日期对象
     * @param datePattern
     *            String 日期格式
     * @return String
     */
    public static String getFormattedString(Date date, String datePattern) {
        SimpleDateFormat sd = new SimpleDateFormat(datePattern);

        return sd.format(date);
    }



}
