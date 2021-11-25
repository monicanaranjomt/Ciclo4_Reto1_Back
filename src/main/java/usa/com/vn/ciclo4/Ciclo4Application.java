package usa.com.vn.ciclo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"usa.com.vn.ciclo4.modelo"})

public class Ciclo4Application {

	public static void main(String[] args) {
		SpringApplication.run(Ciclo4Application.class, args);
	}

}
