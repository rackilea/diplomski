public static int getSize(Object parent) {
    int size = 0;

    for (Field f : parent.getClass().getDeclaredFields()) {
        try {
            f.setAccessible(true);
            Object obj = f.get(parent);
            Field objField = obj.getClass().getDeclaredField("SIZE");
            int fieldSize = (Integer) objField.get(obj);
            size += fieldSize / Byte.SIZE;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return size;
}