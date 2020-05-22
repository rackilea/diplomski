protected Object deserialize(final List<byte[]> blocks) {
    try {
       ObjectInputStream objInputStream = new ObjectInputStream(InputStream(){
            Iterator<byte[]> it=blocks.iterator();
            byte[] curr;
            int ind;
            public int read(){
                if(curr==null||curr.length==ind){
                    if(!it.hasNext())return -1;//or use a blocking queue and pop
                    curr=it.next();
                    ind=0;
                }
                return curr[ind++];
            }
        });
        return objInputStream.readObject();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}