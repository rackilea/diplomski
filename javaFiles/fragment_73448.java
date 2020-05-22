System.setOut(
    new PrintStream(new OutputStream() { 
    @Override
    public  void    close() {}
    @Override
    public  void    flush() {}
    @Override
    public  void    write(byte[] b) {}
    @Override
    public  void    write(byte[] b, int off, int len) {}
    @Override
    public  void    write(int b) {}

    }));
System.setErr(
    new PrintStream(new OutputStream() { 
    @Override
    public  void    close() {}
    @Override
    public  void    flush() {}
    @Override
    public  void    write(byte[] b) {}
    @Override
    public  void    write(byte[] b, int off, int len) {}
    @Override
    public  void    write(int b) {}

    }));