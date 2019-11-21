package ibm.com.cloud.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import ibm.com.cloud.logging.model.Logging;
import ibm.com.cloud.logging.repository.LoggingRepository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class LoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingApplication.class, args);
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("ibm.com.cloud.event.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Logging API").description("Documentation Logging API v1.0").build());
	}
	
	@Bean
	LoggingRepository repository() {
		LoggingRepository repository = new LoggingRepository();
		repository.add(new Logging("John Smith", "14011999"));
		repository.add(new Logging("Darren Hamilton", "14011999"));
		repository.add(new Logging("Tom Scott", "14011999"));
		/*
		 * repository.add(new Event(1L, 2L, "Anna London", 39, "Analyst"));
		 * repository.add(new Event(1L, 2L, "Patrick Dempsey", 27, "Developer"));
		 * repository.add(new Event(2L, 3L, "Kevin Price", 38, "Developer"));
		 * repository.add(new Event(2L, 3L, "Ian Scott", 34, "Developer"));
		 * repository.add(new Event(2L, 3L, "Andrew Campton", 30, "Manager"));
		 * repository.add(new Event(2L, 4L, "Steve Franklin", 25, "Developer"));
		 * repository.add(new Event(2L, 4L, "Elisabeth Smith", 30, "Developer"));
		 */
		return repository;
	}
	
}
