package br.edu.ifg.web;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifg.web.web.CalculadoraServlet;
import br.edu.ifg.web.web.CalculadoraServletJSP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EnableJpaRepositories
public class SpringWebContentApplication extends SpringBootServletInitializer {

    @Bean
    ServletRegistrationBean calculadoraServlet() {
        return new ServletRegistrationBean(new CalculadoraServlet(), "/calcservlet/*");
    }

    @Bean
    ServletRegistrationBean calculadoraJSPServlet() {
        return new ServletRegistrationBean(new CalculadoraServletJSP(), "/calcservletjsp/*");
    }

    @Bean
    ViewResolver resolver() {
        return new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
    }

    @Bean
    SimpleUrlHandlerMapping urlMapping() {
        Map<String, Object> map = new HashMap<>();
        map.put("/jsp/**", new UrlFilenameViewController());
        return new SimpleUrlHandlerMapping(map);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringWebContentApplication.class, args);
    }

}