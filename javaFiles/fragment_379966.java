ValidationResult result = validateInput(someInput);
if (result.hasErrors()) {
 for (ErrorMessage message : result.getErrors()) {
   log.error(message.getMessage());
 } else {
   //success
}