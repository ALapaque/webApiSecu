package be.tftic.webapisecu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class WebApiSecuApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApiSecuApplication.class, args);
    }

}
