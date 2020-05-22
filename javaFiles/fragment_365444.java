public static List<Issue> searchIssues(SearchParametersAggregator searchParams)
{
    String jqlQuery = searchParams.getJqlQuery();
    String projectId = searchParams.getProjectId();
    String condition = createCondition(jqlQuery, projectId);

    JqlQueryBuilder jqlQueryBuilder = prepareJqlQueryBuilder(condition);

    return searchIssues(jqlQueryBuilder);
}

static List<Issue> searchIssues(JqlQueryBuilder jqlQueryBuilder)
{
    Query query = jqlQueryBuilder.buildQuery();
    SearchService searchService = ComponentAccessor.getComponent(SearchService.class);
    try
    {
        ApplicationUser applicationUser = ComponentAccessor.getJiraAuthenticationContext().getUser();
        User user = applicationUser.getDirectoryUser();
        SearchResults searchResults = searchService.search(user, query, PagerFilter.getUnlimitedFilter());
        List<Issue> issues = searchResults.getIssues();

        return issues;
    }
    catch (SearchException e)
    {
        LOGGER.error("Error occurs during search of issues");
        e.printStackTrace();
    }

    return new ArrayList<Issue>();
}

static JqlQueryBuilder prepareJqlQueryBuilder(String condition)
{
    try
    {
        Query query = jqlQueryParser.parseQuery(condition);
        JqlQueryBuilder builder = JqlQueryBuilder.newBuilder(query);

        return builder;
    }
    catch (JqlParseException e)
    {
        throw new RuntimeException("JqlParseException during parsing jqlQuery!");
    }
}