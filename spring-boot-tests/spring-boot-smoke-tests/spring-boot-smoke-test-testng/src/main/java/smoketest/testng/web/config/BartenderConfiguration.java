package smoketest.testng.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smoketest.testng.web.component.Bartender;

/**
 * 通过@Configuration+@Bean 完成Bean对象的注入 BeanName就是应用的方法名 一个BeanName为zhangxiaosan的对象  另一个是zhangdasan
 * @see Bartender
 */
@Configuration
public class BartenderConfiguration {

	@Bean
	public Bartender zhangxiaosan() {
		return new Bartender("张小三");
	}

	@Bean
	public Bartender zhangdasan() {
		return new Bartender("张大三");
	}
}
