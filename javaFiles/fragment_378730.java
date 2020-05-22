public class QDSLSafePageResolver implements PageableArgumentResolver {

private static final String DEFAULT_PAGE = "0";
private static final String DEFAULT_PAGE_SIZE = "20";
private static final String PAGE_PARAM = "page";
private static final String SIZE_PARAM = "size";
private static final String SORT_PARAM = "sort";
private final QDSLAliasRegistry aliasRegistry;

public QDSLSafePageResolver(QDSLAliasRegistry aliasRegistry) {
    this.aliasRegistry = aliasRegistry;
}

@Override
public boolean supportsParameter(MethodParameter parameter) {
    return Pageable.class.equals(parameter.getParameterType())
            && parameter.hasParameterAnnotation(QDSLPageable.class);
}

@Override
public Pageable resolveArgument(MethodParameter parameter,
                                ModelAndViewContainer mavContainer,
                                NativeWebRequest webRequest,
                                WebDataBinderFactory binderFactory) {

    MultiValueMap<String, String> parameterMap = getParameterMap(webRequest);

    final Class<?> root = parameter.getParameterAnnotation(QDSLPageable.class).root();
    final ClassTypeInformation<?> typeInformation = ClassTypeInformation.from(root);

    String pageStr = Optional.ofNullable(parameterMap.getFirst(PAGE_PARAM)).orElse(DEFAULT_PAGE);
    String sizeStr = Optional.ofNullable(parameterMap.getFirst(SIZE_PARAM)).orElse(DEFAULT_PAGE_SIZE);
    int page = Integer.parseInt(pageStr);
    int size = Integer.parseInt(sizeStr);
    List<String> sortStrings = parameterMap.get(SORT_PARAM);
    if(sortStrings != null) {
        OrderSpecifier[] specifiers = new OrderSpecifier[sortStrings.size()];

        for(int i = 0; i < sortStrings.size(); i++) {
            String sort = sortStrings.get(i);
            String[] orderArr = sort.split(",");
            Order order = orderArr.length == 1 ? Order.ASC : Order.valueOf(orderArr[1].toUpperCase());
            specifiers[i] = buildOrderSpecifier(orderArr[0], order, typeInformation);
        }

        return new QPageRequest(page, size, specifiers);
    } else {
        return new QPageRequest(page, size);
    }
}

private MultiValueMap<String, String> getParameterMap(NativeWebRequest webRequest) {
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();

    for (Map.Entry<String, String[]> entry : webRequest.getParameterMap().entrySet()) {
        parameters.put(entry.getKey(), Arrays.asList(entry.getValue()));
    }
    return parameters;
}

private OrderSpecifier<?> buildOrderSpecifier(String sort,
                                              Order order,
                                              ClassTypeInformation<?> typeInfo) {


    Expression<?> sortPropertyExpression = new PathBuilderFactory().create(typeInfo.getType());
    String dotPath = aliasRegistry.getDotPath(sort);
    PropertyPath path = PropertyPath.from(dotPath, typeInfo);
    sortPropertyExpression = Expressions.path(path.getType(), (Path<?>) sortPropertyExpression, path.toDotPath());

    return new OrderSpecifier(order, sortPropertyExpression);
}
}