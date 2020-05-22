roach$ javac -source 1.6 -target 1.6 test.java
warning: [options] bootstrap class path not set in conjunction with -source 1.6
test.java:9: error: multi-catch statement is not supported in -source 1.6
    } catch (NullPointerException | BufferOverflowException ex) {}
                                  ^
  (use -source 7 or higher to enable multi-catch statement)
1 error
1 warning