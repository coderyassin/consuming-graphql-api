package com.example.demo.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class PropertiesConfig {

    @Bean(name="queriesProperties")
    public static PropertiesFactoryBean propertiesBean() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        Resource[] resourceLocations = new Resource[]{
                new ClassPathResource("META-INF/queries.xml")
        };
        propertiesFactoryBean.setLocations(resourceLocations);
        propertiesFactoryBean.setFileEncoding("UTF-8");
        return propertiesFactoryBean;
    }

}
