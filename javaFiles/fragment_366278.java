@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(
                type = FilterType.CUSTOM, classes = { ExcludePackageTypeFilter.class }))
public class Application {


}