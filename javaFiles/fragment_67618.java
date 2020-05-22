try {
        List<Object> tempList = new ArrayList<Object>();
        while (true) {
            tempList.add(new byte[128 * 1024 * 1024 * 1024]);
        }
    } catch (OutOfMemoryError OME) {
       // OK, Garbage Collector will have run now...
    }