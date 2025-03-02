//package com.example.ai.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import feign.Logger;
//import lombok.extern.slf4j.Slf4j;
//import okhttp3.OkHttpClient;
//
//@Slf4j
//@Configuration
//public class FeignClientConfiguration
//{
//    @Bean
//    OkHttpClient client()
//    {
//        return new OkHttpClient();
//    }
//
//    @Bean
//    Logger getLogger()
//    {
//        return new MyFeignLog();
//    }
//
//    @Bean
//    Logger.Level feignLoggerLevel()
//    {
//        return Logger.Level.BASIC;
//    }
//
//    private static class MyFeignLog extends feign.Logger
//    {
//        @Override
//        protected void log(String configKey, String format, Object... args)
//        {
//            log.debug(String.format(methodTag(configKey) + format, args));
//        }
//    }
//}


