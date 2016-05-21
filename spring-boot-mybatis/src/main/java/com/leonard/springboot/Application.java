package com.leonard.springboot;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by Leonard on 2016/5/5.
 */
@SpringBootApplication
@MapperScan("com.leonard.springboot.mapper")
public class Application {

    /**
     * 配置Druid的内置监控页面
     * @return
     */
    @Bean
    public ServletRegistrationBean druidStatViewRegistration() {
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }

    /**
     * 配置Druid的监控统计过滤排除项
     * @return
     */
    @Bean
    public FilterRegistrationBean druidWebStatFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new WebStatFilter());
        registration.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return registration;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
