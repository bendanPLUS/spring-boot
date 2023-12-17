package smoketest.testng.web.annotation;


import org.springframework.context.annotation.Import;
import smoketest.testng.web.component.Boss;
import smoketest.testng.web.config.BartenderConfiguration;
import smoketest.testng.web.registrar.WaiterRegistrar;
import smoketest.testng.web.selector.BarImportSelector;
import smoketest.testng.web.selector.WaiterDeferredImportSelector;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({Boss.class, BartenderConfiguration.class, BarImportSelector.class, WaiterRegistrar.class, WaiterDeferredImportSelector.class})
public @interface EnableTavern {
}
