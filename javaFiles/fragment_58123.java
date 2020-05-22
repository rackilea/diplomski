FileAppender.Builder b = FileAppender.newBuilder();
b.withFileName("TestFile");
b.withAppend(true);
b.setName("my-appender");
b.build();
FileAppender fa = b.build();