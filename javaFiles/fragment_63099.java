PythonInterpreter interpreter = new PythonInterpreter();
interpreter.execfile(file.getAbsolutePath());
interpreter.exec("import inspect"); 
PyDictionary dico=(PyDictionary) interpreter.eval("dict([(k, inspect.getargspec(v).args) for (k, v) in locals().items() if inspect.isfunction(v)])"); 
ConcurrentMap<PyObject, PyObject> map= dico.getMap();
map.forEach((k,v)->{
    System.out.println(k.toString());   
    System.out.println(v.toString());   
});