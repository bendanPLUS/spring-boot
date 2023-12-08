package smoketest.testng.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import smoketest.testng.typeExcludeFilterTest.TypeExcludeFilterTest;

import java.util.HashMap;
import java.util.Map;

@Order(1)
public class ApplicationContextInitializerTest implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		applicationContext.getBeanFactory().registerSingleton(TypeExcludeFilterTest.class.getName(), new TypeExcludeFilterTest());
	}
}
