public static <T> ArrayList<T> parseLog(File log, Class<T> cls) throws Exception {
        ArrayList<T> objList = new ArrayList<T>();
        FileInputStream fis = new FileInputStream(log);
        ObjectInputStream in = new ObjectInputStream(fis);
        try {
            Object obj;
            while (!((obj = in.readObject()) instanceof EOFObject)) {
                T tobj = (T) obj;
                objList.add(tobj);
            }
        } finally {
            in.close();
        }
        return objList;
    }