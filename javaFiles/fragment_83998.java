Observable.just(bitmap)
                .map(b -> {
                    try {
                        // do some work which throws IOException
                        throw new IOException("something went wrong");
                    } catch (IOException e) {
                        throw new RXIOException(e);
                        // Or you can use 
                        throw Exceptions.propagate(e);
                        // This helper method will wrap your exception with runtime one
                    }
                }).subscribe(o -> {
                    // do something here
                }, exception -> exception.printStackTrace());

public static class RXIOException extends RuntimeException {
        public RXIOException(IOException throwable) {
            super(throwable);
        }
}