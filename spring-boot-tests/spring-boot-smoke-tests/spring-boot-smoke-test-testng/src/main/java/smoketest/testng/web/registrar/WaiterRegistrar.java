package smoketest.testng.web.registrar;


import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import smoketest.testng.web.component.Waiter;

public class WaiterRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		System.out.println("WaiterRegistrar invoke ......");
		registry.registerBeanDefinition("waiter", new RootBeanDefinition(Waiter.class));
	}
}
