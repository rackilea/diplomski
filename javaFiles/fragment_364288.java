@Named("mapDiagnosisCodeAsList")
default List<Diagnosis> retrieveDiagnosisCodeAsList(List<String> aList) {
    if (CollectionUtils.isEmpty(aList)) {
        return new ArrayList<>();
    }
    return aList.stream().map(Diagnosis::new).collect(Collectors.toList());
}