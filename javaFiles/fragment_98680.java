if (CollectionUtils.isEmpty(inputList)) return Lists.newArrayList();

List<Input1> matchedInputs = inputList.stream()
    .filter(Objects::nonNull)
    .filter(in -> !ObjectUtils.isEmpty(in.getterMenthod()))
    .filter(in -> in.getterMenthod().compareTo(Enum.key) == 0)
    .collect(toList());

List<sameReturnType> sameReturnTypeList = matchedInputs.stream()
    .map(in -> converter.convert(in, sameReturnType.class))
    .collect(toList());

inputList.removeAll(matchedInputs);

return sameReturnTypeList;