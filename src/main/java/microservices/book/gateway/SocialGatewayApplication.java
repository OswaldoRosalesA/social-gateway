package microservices.book.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SocialGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialGatewayApplication.class, args);
	}

}
