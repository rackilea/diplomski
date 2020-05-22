class MyClass {
    String myPath = null;
    ...
    // call the path method which opens the file dialog
    myPath = path();
    ...
    // use the saved result
    tf.guardarTareasHash(operator.obtenerTabla(), "modificar", myPath);
}