// Import necessary Spring Framework packages
package com.example.springtodolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

// Annotate the class as a Configuration class to indicate that it should be used for Spring configuration
@Configuration
public class Config implements WebMvcConfigurer {

    // Override the addResourceHandlers method to specify custom resource handling
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map /css/** URL patterns to classpath:/templates/css/ directory
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/templates/css/");
        // Map /js/** URL patterns to classpath:/templates/js/ directory
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/templates/js/");
    }

    // Define a Spring Bean for JdbcTemplate and inject DataSource as a dependency
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        // Create a new JdbcTemplate object and pass the dataSource to it
        return new JdbcTemplate(dataSource);
    }
}