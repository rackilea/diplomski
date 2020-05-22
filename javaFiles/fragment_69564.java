@Autowired
private Facebook fb;

private Filter ssoFilter() {        
    CompositeFilter filter = new CompositeFilter();
    List<Filter> filters = new ArrayList<>();
    filters.add(ssoFilter(fb.getConfig(), "/login/facebook"));
    filters.add(ssoFilter(github(), "/login/github"));
    filter.setFilters(filters);
    return filter;
}