package inetum.feign.usermc.communication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
 @Configuration
public class AppConfig {
     @Bean
     public RestTemplate getRestTemplate() {
         return new RestTemplate();
     }








}
