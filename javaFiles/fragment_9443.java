@RequestMapping(value = "test", method = RequestMethod.POST)
@ResponseBody
public String getTest(@RequestBody long longValue, BindingResult result) {
  if (longValue > 32) {
     result.rejectValue("longValue", "error.longValue", "longValue max constrained failed");
    return "failed validation";
  } else {
    return "passed validation";
  }
}