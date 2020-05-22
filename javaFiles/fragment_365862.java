private boolean isNotJsonString(final String value) throws IOException {
    // strictly speaking, should also test for equals("null") since {"example": null} would be valid JSON
    // but swagger2 does not support null values
    // and an example value of "null" probably does not make much sense anyway
    return value.startsWith("{")                              // object
        || value.startsWith("[")                          // array
        || "true".equals(value)                           // true
        || "false".equals(value)                          // false
        || JSON_NUMBER_PATTERN.matcher(value).matches();  // number
  }