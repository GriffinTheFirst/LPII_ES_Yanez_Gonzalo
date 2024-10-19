package pe.edu.cinertec.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"pe.edu.cinertec.thymeleaf.controller","pe.edu.cinertec.web.service"})
@PropertySource("classpath:application.properties")

public class LpiiEsYanezGonzaloApplication {

	public static void main(String[] args) {
		SpringApplication.run(LpiiEsYanezGonzaloApplication.class, args);
	}

}
