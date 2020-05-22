// Hamcrest assertion
assertThat(person.getName(), containsString("myName"));

// Error Message
java.lang.AssertionError:
Expected: a string containing "myName"
     got: "some other name"