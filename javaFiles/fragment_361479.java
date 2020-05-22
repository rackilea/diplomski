//---

    private PrintWriter printWriter = null;
    private ServletOutputStream outputStream = null;

    public PrintWriter getWriter( ) throws IOException {

        if (this.outputStream != null) {
            throw new IllegalStateException(
                    "Cannot call getWriter( ) after getOutputStream( )");
        }

        if (this.printWriter == null) {
            // initialize printWriter
        }
        return this.printWriter;
    }

    public ServletOutputStream getOutputStream( ) throws IOException {

        if (this.printWriter != null) {
            throw new IllegalStateException(
                "Cannot call getOutputStream( ) after getWriter( )");
        }

        if (this.outputStream == null) {
            // initialize outputStream
        }
        return this.outputStream;
    }

//---