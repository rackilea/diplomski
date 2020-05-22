@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        // If we don't provide a datasource, an in-memory map will be used.
    }
}