LabelProvider<MyObject> labelProvider = new LabelProvider<MyObject>(){
    @Override
    public String getLabel(MyObject item){
        return item.getFrom() + " - " + item.getTo();
    }
}