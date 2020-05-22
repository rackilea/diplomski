@Autowired
private SummaryCache cache;

public ItemProcessor<YourDto> createProcessor() {
   return item -> {
          cache.addValue(item.getId(), item.getValue();
          return item;
   };
}