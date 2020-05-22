class AnalyzingOutputStream extends FilterOutputStream {

    public AnalyzingOutputStream (OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) {
          // do whatever analysis you want
          super.write(b);  // delegate to super class' write, which will 
                           // delegate to the filtered outputstream
    }
    // other overrides
}