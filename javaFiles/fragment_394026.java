@Override
    public Object next() {
        if(this.hasNext()){
            return names[index++];
        }
        return null;
    }