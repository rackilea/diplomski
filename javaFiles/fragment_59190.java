@Configuration
public class ArticleConfig {

    @Bean
    public ArticleMD5HashCalculator articleMD5HashCalculator() {
        return new ArticleMD5HashCalculator(new MD5HashCalculator());
    }

    @Bean
    public ArticleBuilder() {
        return new ArticleBuilder(articleMD5HashCalculator());
    }
}