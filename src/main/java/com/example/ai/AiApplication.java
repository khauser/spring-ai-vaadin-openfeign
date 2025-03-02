package com.example.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;

@SpringBootApplication
@EnableFeignClients
// @EnableReactiveFeignClients
@Push
public class AiApplication implements AppShellConfigurator
{

    private static final long serialVersionUID = 1L;

    public static void main(String[] args)
    {
        SpringApplication.run(AiApplication.class, args);
    }

}
