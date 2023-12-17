package smoketest.testng.web.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import smoketest.testng.web.component.Bar;
import smoketest.testng.web.config.BarConfiguration;


public class BarImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		System.out.println("BarImportSelector invoke ......");
		return new String[] {Bar.class.getName(), BarConfiguration.class.getName()};
	}
}
