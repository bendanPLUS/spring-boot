package smoketest.testng.typeExcludeFilterTest;

import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import smoketest.testng.service.HelloWorldService;

import java.io.IOException;

/**
 *  自定义类型排除过滤器
 *  {@link TypeExcludeFilter#match(MetadataReader, MetadataReaderFactory)}
 *  {@link org.springframework.boot.context.TypeExcludeFilter#getDelegates()}
 */
@Component
public class TypeExcludeFilterTest extends TypeExcludeFilter {
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		// 自定义一些排除过滤规则
		return metadataReader.getClass().getName().equals(HelloWorldService.class.getName());
	}
}
