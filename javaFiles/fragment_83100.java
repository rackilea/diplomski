@Component
public class Utils{

@ComponentImport
private SearchProvider searchProvider;

@ComponentImport
private UserManager userManager;

@ComponentImport
private IssueManager issueManager;


@Inject
public Utils( IssueManager issueManager, UserManager userManager, SearchProvider searchProvider ){
    this.issueManager = issueManager;
    this.userManager = userManager;
    this.searchProvider = searchProvider;
    ...
}

...

public List<Issue> getIssuesByDateUpdateAfter( Date dTime ) throws SearchException{
    JqlQueryBuilder builder = JqlQueryBuilder.newBuilder();
    builder.where().addDateCondition( IssueFieldConstants.UPDATED, Operator.GREATER_THAN_EQUALS, dTime );
    return searchIssues( builder.buildQuery() );
}

public List<Issue> searchIssues( Query query ){
    ApplicationUser user = userManager.getUserByName( username );
    SearchQuery searchQuery = SearchQuery.create( query, user );
    IssueIdCollector collector = new IssueIdCollector();
    try{
        ThreadLocalSearcherCache.startSearcherContext();
        searchProvider.search( searchQuery, collector );
    }catch( Exception e ){
        e.getMessage();
    }finally{
        ThreadLocalSearcherCache.stopAndCloseSearcherContext();
    }
    return searchIssues(collector);
}

public List<Issue> searchIssues(IssueIdCollector collector){
    Set<String> strIds = collector.getIssueIds();
    List<Long> ids = new ArrayList<>();
    for( String strId : strIds ){
        ids.add( Long.parseLong( strId ) );
    }
    return issueManager.getIssueObjects( ids );
}

...
}