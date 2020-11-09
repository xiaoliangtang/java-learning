package com.java.learning.base.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.*;
import java.util.Locale;

public class NewApi {

    public static void main(String[] args)
    {
        base();
        zoned();
        instant();
        temporalAdjuster();
    }

    static void base()
    {
        System.out.println("LocalDate.now:" + LocalDate.now());
        System.out.println("LocalTime.now:" + LocalTime.now());
        System.out.println("NewApi.now:" + java.time.LocalDateTime.now());

        LocalDateTime localDateTime = java.time.LocalDateTime.now();

        // 日期时间加减
        LocalDateTime localDateTime2 = localDateTime.plusDays(1).minusHours(2).plusMinutes(60);

        // format
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dtfDate = dtf.format(localDateTime2);
        System.out.println("dtfDate:" + dtfDate);
    }

    static void zoned()
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = localDateTime.atZone(ZoneId.systemDefault());
        ZonedDateTime zonedDateTime2 = localDateTime.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime zonedDateTime3 = zonedDateTime1.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("zonedDateTime1:" + zonedDateTime1);
        System.out.println("zonedDateTime2:" + zonedDateTime2);
        System.out.println("zonedDateTime3:" + zonedDateTime3);
    }

    static void instant()
    {
        Instant instant = Instant.now();
        long epochSecond = instant.getEpochSecond();
        long epochMilli = instant.toEpochMilli();

        System.out.println("epochSecond:" + epochSecond);
        System.out.println("epochMilli:" + epochMilli);
    }

    /**
     * 临时调整器
     */
    static void temporalAdjuster()
    {
        LocalDate localDate = LocalDate.now();

        // 预定义实现
        System.out.println(localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println(localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)));
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));

        // 自定义临时调整器
        TemporalAdjusterByNextWorkingDay temporalAdjusterByNextWorkingDay = new TemporalAdjusterByNextWorkingDay();
        System.out.println(localDate.with(temporalAdjusterByNextWorkingDay));
        System.out.println(localDate.with(NEXT_WORKING_DAY));
        System.out.println(localDate.with(ADD_TEM_DAY));
    }

    /**
     * 自定义临时调整器（实现TemporalAdjuster 接口）-下一个工作日
     */
    static class TemporalAdjusterByNextWorkingDay implements TemporalAdjuster
    {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int addDays;
            switch (dayOfWeek) {
                case FRIDAY:
                    addDays = 3;
                    break;
                case SATURDAY:
                    addDays = 2;
                    break;
                default:
                    addDays = 1;
            }

            return temporal.plus(addDays, ChronoUnit.DAYS);
        }
    }

    /**
     * 自定义临时调整器（lambda表达式）
     */
    static TemporalAdjuster NEXT_WORKING_DAY = TemporalAdjusters.ofDateAdjuster(localDate -> {
        // 下一个工作日
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int addDays;
        switch (dayOfWeek) {
            case FRIDAY:
                addDays = 3;
                break;
            case SATURDAY:
                addDays = 2;
                break;
            default:
                addDays = 1;
        }

        return localDate.plus(addDays, ChronoUnit.DAYS);
    });

    /**
     * 自定义临时调整器（lambda表达式）-添加10天
     */
    static TemporalAdjuster ADD_TEM_DAY = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.plusDays(10));
}
