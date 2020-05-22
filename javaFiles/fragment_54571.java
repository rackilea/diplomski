List<String> validParams = Arrays.asList(QueryParams.values()).stream().map(QueryParams::getParamValue).collect(Collectors.toList());
    queryParams.removeAll(validParams);
    if(queryParams.size()!=0) {
        throw new FailureResponse();
    }
}