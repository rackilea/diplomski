@RequestMapping(value = "/graphql", method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ResponseBody
public String execute(@RequestBody Map<String, Object> request) throws IOException {
    ExecutionInput executionInput = ExecutionInput.newExecutionInput()
            .query((String) request.get("query"))
            .operationName((String) request.get("operationName"))
            // THE FOLLOWING LINE WAS ABSENT:
            .variables((Map<String, Object>) request.get("variables"))
            .build();
    ExecutionResult executionResult = graphQL.execute(executionInput);
    return mapper.writeValueAsString(executionResult);
}