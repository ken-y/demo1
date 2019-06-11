package com.ken.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

public class DateComUtil {

    private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String formatDate(Date date){
        synchronized (sdf){
            return sdf.format(date);
        }
    }
    public static Date parse(String strDate) throws ParseException {
        synchronized (sdf){
            return sdf.parse(strDate);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //单线程
        System.out.println(sdf.format(new Date()));
        //多线程
        ExecutorService executorService= newFixedThreadPool(100);
        for(int i=0;i<20;i++){
            executorService.execute(()->{
                for(int j=0;j<10;j++){
                    try {
                        //System.out.println(parse("2019-05-13 11:14:28"));
                        System.out.println(parse2("2019-05-13 11:14:28"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //等待上述线程执行完
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

    //alibaba
    private static final DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatDate2(LocalDateTime date){
        return formatter.format(date);
    }
    public static  LocalDateTime parse2(String strDate){
        return LocalDateTime.parse(strDate,formatter);
    }
}
