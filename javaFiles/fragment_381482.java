@PostConstruct
public void orderArgumentResolvers() {
    List<HandlerMethodArgumentResolver> resolvers = new ArrayList<>(adapter.getArgumentResolvers());
    Collections.sort(resolvers, new OrderComparator());
    adapter.setArgumentResolvers(resolvers);
}