Throwable runtime = new RuntimeException("no way", 
                                         new Exception("you shall not pass"));

assertThat(runtime).hasCauseInstanceOf(Exception.class)
                   .hasStackTraceContaining("no way")
                   .hasStackTraceContaining("you shall not pass");