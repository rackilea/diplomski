317    public synchronized byte[] toByteArray() {
318        int remaining = count;
319        if (remaining == 0) {
320            return EMPTY_BYTE_ARRAY; 
321        }
322        byte newbuf[] = new byte[remaining];
           //Do stuff
333        return newbuf;
334    }