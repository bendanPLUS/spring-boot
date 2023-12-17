package smoketest.testng.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smoketest.testng.web.component.Bar;

@Configuration
public class BarConfiguration {

	@Bean
	public Bar bbbar() {
		return new Bar();
	}
}

