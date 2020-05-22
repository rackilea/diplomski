Properties p = new Properties();
p.setProperty("python.path", "J:/WS/jython"); // Sets the module path

PythonInterpreter.initialize(System.getProperties(), p, new String[]{ "Foo", "Bar" });

PythonInterpreter interpreter = new PythonInterpreter();
interpreter.execfile("J:/WS/jython/main.py");