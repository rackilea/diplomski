@RequestMapping(value = "/saveLimXrefHvo.do", method = RequestMethod.PUT, consumes="application/json", produces="application/json")
public ResponseMap saveLimXrefHvo(@JsonParam(innerType=LimitXrefHvo.class)  List<LimitXrefHvo> limitXrefHvoList) throws JsonParseException, JsonMappingException,  IOException {

    limitService.saveLimXrefHvo(limitXrefHvoList);

    return new ResponseMap("Success");
}