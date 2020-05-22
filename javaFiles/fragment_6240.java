private static String getVariable(oracle.sql.BLOB blob, String name) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());
        try {
            //noinspection unchecked
            return ((HashMap<String, String>) ((StorageBean) ois.readObject()).variables).get(name);
        } finally {
            ois.close();
        }
    }