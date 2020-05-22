private static String getVariable(oracle.sql.BLOB blob, String name) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());
        try {
            ois.skipBytes(variablesOffset);
            //noinspection unchecked
            return ((HashMap<String, String>) ois.readObject()).get(name);
        } finally {
            ois.close();
        }
    }