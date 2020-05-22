private final String allowableValues;

public SwaggerConfiguration() {
  List<YourEntitiy> list = someService.findAll();
  //code to get every value you need and add create comma separated String
  StringJoiner stringJoiner = new StringJoiner(",");
  stringJoiner.add(list.get(0).getValue());

  this.allowableValues = stringJoiner.toString();
}

@ApiParam(allowableValues = allowableValues)