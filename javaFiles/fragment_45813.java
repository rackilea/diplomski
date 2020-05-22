try {
    System.out.println(LinearAlgebra.VectorAdd(v1, v2));
} catch (IllegalOperandException e) {
    // do something with the exception, for instance:
    e.printStackTrace();
    // maybe do something to log it to a file, or whatever...
    // or you might be able to recover gracefully...
    // or if there's just nothing you can do about it, then you might:
    System.exit(1);
}