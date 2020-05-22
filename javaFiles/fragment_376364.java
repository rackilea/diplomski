private void execute(Executor ex) {
    try {
      ex.exec();
    } catch(...) {
      ...
    } finally {
       ...
    }
}