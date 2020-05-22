System.setIn(new FilterInputStream(System.in){
    @Override
    public void close(){
        throw new RuntimeException("System.in closed!");
    }
} );