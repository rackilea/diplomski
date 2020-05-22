@Override
protected void finalize() throws Throwable {
    System.out.println("finalize() invoked for " + this);
    super.finalize();
    Main.flag = true;
}