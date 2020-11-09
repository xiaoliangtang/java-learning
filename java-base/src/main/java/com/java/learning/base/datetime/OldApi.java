package com.java.learning.base.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class OldApi {

    public static void main(String[] args)
    {
        currentTimeMillis();
        date();
        calendar();
        timeZone();
    }

    public static void date()
    {
        Date date = new Date();

        System.out.println("date:" + date);
        System.out.println("getTime:" + date.getTime());
        System.out.println("toString:" + date.toString());
        System.out.println("toGMTString:" + date.toGMTString());

        // format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sdfDate = sdf.format(date);
        System.out.println("sdfDate:" + sdfDate);
    }

    public static void calendar()
    {
        Calendar calendar = Calendar.getInstance();
        System.out.println("Calendar:" + calendar);
        // clear
        calendar.clear();

        // set calendar
        calendar.set(Calendar.YEAR, 2030);
        calendar.set(Calendar.HOUR, 11);

        // 日期时间加减
        calendar.add(Calendar.HOUR, 20);
        calendar.add(Calendar.MINUTE, 10);

        // calendar to date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("sdfCalendar:" + sdf.format(calendar.getTime()));
    }

    public static void timeZone()
    {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        String date = sdf.format(calendar.getTime());// sdf.format(new Date())
        System.out.println("New_York:" + date);
    }

    public static void currentTimeMillis()
    {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis:" + currentTimeMillis);
    }
}
