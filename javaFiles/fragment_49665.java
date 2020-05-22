try {
        runProcess("javac src/HelloWorld.java");
        runProcess("java -classpath src HelloWorld");
    } catch (Exception e) {
      e.printStackTrace();
    }