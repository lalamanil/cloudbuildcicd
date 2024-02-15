package com.cloudbuild.cicd.app;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App {
	private static final Logger LOGGER = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(App.class, args);
		int totalnumberOfbeans = applicationContext.getBeanDefinitionCount();
		System.out.println("total number of beans registered:" + totalnumberOfbeans);
		String[] beannames = applicationContext.getBeanDefinitionNames();
		if (null != beannames && beannames.length > 0) {
			Stream.of(beannames).forEach(bean -> {
				System.out.println(bean);
			});
		} else {
			System.out.println("beans defined in application context is null or empty");
		}

	}
}
