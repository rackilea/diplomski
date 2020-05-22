String _R_ = "\\R";
System.out.println("\r\n".matches("((?<!"+_R_+")\\s)*")); // true

// using "equivalent" pattern
_R_ = "\\u000D\\u000A|[\\u000A\\u000B\\u000C\\u000D\\u0085\\u2028\\u2029]";
System.out.println("\r\n".matches("((?<!"+_R_+")\\s)*")); // false

// now make it atomic, as per sln's answer
_R_ = "(?>"+_R_+")";
System.out.println("\r\n".matches("((?<!"+_R_+")\\s)*")); // true