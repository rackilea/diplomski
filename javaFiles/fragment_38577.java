public static class StatefulConsumer implements IntConsumer {

    private static final Integer ARBITRARY_THRESHOLD = 10;
    private boolean flag = false;
    private final List<Integer> list = new ArrayList<>();

    @Override
    public void accept(int value) {
        if(flag){   // exit condition
            return; 
        }
        if(value >= ARBITRARY_THRESHOLD){
            flag = true;
        }
        list.add(value); 
    }

}