package smoketest.testng.web.selector;

import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import smoketest.testng.web.component.Waiter;

import java.util.ArrayList;
import java.util.List;

public class WaiterDeferredImportSelector implements DeferredImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		System.out.println("WaiterDeferredImportSelector invoke ......");
		return new String[]{Waiter.class.getName()};
	}


	/**
	 * DeferredImportSelectorGroupingHandler 增加组的概念
	 * 调用时机: {@link org.springframework.context.annotation.ConfigurationClassParser.DeferredImportSelectorGroupingHandler#register(org.springframework.context.annotation.ConfigurationClassParser.DeferredImportSelectorHolder)
	 *            拿到 WaiterDeferredImportSelector->WaiterDeferredImportSelectorGroup 对应的组
	 *            Class<? extends Group> group = deferredImport.getImportSelector().getImportGroup();}
	 */
	@Override
	public Class<? extends Group> getImportGroup() {
		return WaiterDeferredImportSelector.WaiterDeferredImportSelectorGroup.class;
	}

	/**
	 * 实现接口DeferredImportSelector分组的概念
	 */
	private static class WaiterDeferredImportSelectorGroup implements Group {

		private final List<Entry> imports = new ArrayList<>();

		@Override
		public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
			for (String importClassName : selector.selectImports(metadata)) {
				this.imports.add(new Entry(metadata, importClassName));
			}

			/**
			 * 其实不用写for循环, 如果用分组的大概念可以直接添加,不必再掉{@link #selectImports(AnnotationMetadata)}
			 * 参考自动装配的写法:{@link AutoConfigurationImportSelector.AutoConfigurationGroup#selectImports()}
			 * 注:如果你不创建(WaiterDeferredImportSelectorGroup)group 解析器{@link ConfigurationClassParser}会为你创建默认的group{@link ConfigurationClassParser.DefaultDeferredImportSelectorGroup}
			 * 创建默认的group时机:
			 * 1.{@link ConfigurationClassParser.DeferredImportSelectorGroupingHandler#register(ConfigurationClassParser.DeferredImportSelectorHolder) -> key -> new DeferredImportSelectorGrouping(createGroup(group)}
			 * 2.{@link ConfigurationClassParser.DeferredImportSelectorGroupingHandler#createGroup(Class)}  - > Class<? extends Group> effectiveType = (type != null ? type : DefaultDeferredImportSelectorGroup.class);
			 */
			// this.imports.add(new Entry(metadata, Waiter.class.getName()));
		}

		@Override
		public Iterable<Entry> selectImports() {
			return this.imports;
		}
	}
}