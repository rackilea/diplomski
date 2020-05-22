// Hamcrest assertion with custom error message
assertThat("my error message", person.getName(), containsString("myName"));

// Error Message
java.lang.AssertionError: my error message
Expected: a string containing "myName"
     got: "some other name"