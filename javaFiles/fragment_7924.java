public class ByteCache {

    ArrayList<Byte> backing = new ArrayList<Byte>();

    public ByteCache(){
    }

    public ByteCache(Byte[] bytes){
        add(bytes);
    }

    public void add(Byte[] bytes){
        for(Byte b : bytes){
            backing.add(b);
        }
    }

    public int length(){
        return backing.size();
    }

    public Byte[] get(int offset, int length){
        if(offset < 0 || length < 1){
            return null;
        }

        Byte[] toRet = new Byte[length];

        for(int i = offset; i < offset + length; i++){
            if(i == backing.size()){
                break;
            }
            toRet[i - offset] = backing.get(i);
        }
        return toRet;
    }
}