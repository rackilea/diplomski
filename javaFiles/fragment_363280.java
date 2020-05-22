public void perform(final List<MyObject> list, final String name){
    list.stream().filter(o -> o.getName().equals(name)).forEach(
            o -> {
                //...
            }
    );
}