// extract status code and message
  variables.result.code = variables.connection.getResponseCode();
  variables.result.message = variables.connection.getResponseMessage();

  // Simplified example, adjust as needed
  if (variables.result.code == variables.connection.HTTP_OK) {
      variables.result.text = streamToString(variables.connection.getInputStream());
  }
  else {
      variables.result.error = streamToString(variables.connection.getErrorStream());
  }

  // show results
  WriteDump(variables.result);