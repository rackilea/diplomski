// Java 7 onwards
byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

// Java pre-7
byte[] bytes = text.getBytes("UTF-8");

// .NET
byte[] bytes = Encoding.UTF8.GetBytes(text);