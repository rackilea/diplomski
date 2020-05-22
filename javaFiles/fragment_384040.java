// cache an undefined number of ids so that the length of all the strings 
// do not exceed 100000 characters
LruCache<Integer, String> idToCustomerName = new LruCache<>(100000) {
    @Override
    protected int sizeOf(Integer key, String value) {
       return value.length();
    }
};