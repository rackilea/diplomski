@AnalyzerDef(name = "sort_analyzer",
   tokenizer = @TokenizerDef(factory = KeywordTokenizerFactory.class),
   filters = {
       @TokenFilterDef(factory = ASCIIFoldingFilterFactory.class),
       @TokenFilterDef(factory = LowerCaseFilterFactory.class)
   }
)
public class FeatureMeta {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String uri;

    @Column
    @Field
    @Field(name = "name_sort", analyzer = @Analyzer(definition = "sort_analyzer"))
    private String name;

    @Field
    @Column
    private String businessDesc;

    @Field
    @Column
    private String logicalDesc;

    .
    .

}