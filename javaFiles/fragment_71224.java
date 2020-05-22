public class Student implements Serializable {
    private transient ObjectNode name;

    private void writeObject(ObjectOutputStream out) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        out.writeUTF(mapper.writeValueAsString(name));
        // other fields here
    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.readTree(in.readUTF());
        if (!node.isObject()) {
            throw new IOException("malformed name field detected");
        }

        name = (ObjectNode) node;

        // read other fields
    }
}