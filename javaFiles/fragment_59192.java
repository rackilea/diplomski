@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ArticleBuilder {

    @Autowired
    private ArticleMD5HashCalculator hashCalculator;

    public ArticleBuilder(ArticleMD5HashCalculator hashCalculator) { 
        this.hashCalculator = hashCalculator;
    }
}

@Component
public class ArticleMD5HashCalculator {

    public ArticleMD5HashCalculator(MD5HashCalculator hashCalculator) {
        this.hashCalculator = hashCalculator;
    }
}