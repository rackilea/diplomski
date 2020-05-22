public MyResponseDto doSomeWork(MyRequestDto) {
  ....
  String jsonStr = null;
  try {
    jsonStr = new ObjectMapper().writeValueAsString(MyRequestDto);
  } catch (JsonGenerationException | JsonMappingException e) {
    log.error(e.getMessage());
    myResponseDto .setWorkDone(false);
    myResponseDto .setErrorMessage(e.getMessage());
    return myResponseDto ;
  } 
  myResponseDto = postWorkRequest(jsonStr);
  return myResponseDto ;
}