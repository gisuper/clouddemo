package com.cloud.consumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker*/
@EnableFeignClients
@SpringCloudApplication
public class ConsumerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDemoApplication.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
