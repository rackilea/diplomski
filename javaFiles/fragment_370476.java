private SortAlgorithm sorter;

@Autowired 
public BinarySearchImpl(@Qualifier("quick") SortAlgorithm sorter) {
     this.sorter = sorter;
}