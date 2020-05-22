import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SerializationProgram {

    public static void main(String[] args) throws Exception {
        emptyTest();
        addAndRemoveTest();
    }

    private static void emptyTest() throws Exception {
        ObjectSerializer serializer = new ObjectSerializer();
        serializer.serialize(new FileStatus());
        FileStatus persisted = serializer.deserialize(FileStatus.class);
        test(persisted, new FileStatus());
    }

    private static void addAndRemoveTest() throws Exception {
        ObjectSerializer serializer = new ObjectSerializer();
        FileStatus toPersist = new FileStatus();
        FileStatus mirror = new FileStatus();

        toPersist = serializeDeserializeAndTest(serializer, toPersist, mirror);

        File file = new File("/test/test.txt");
        Boolean status = Boolean.TRUE;

        // Add file status
        toPersist.addOrChangeStatus(file, status);
        mirror.addOrChangeStatus(file, status);

        toPersist = serializeDeserializeAndTest(serializer, toPersist, mirror);

        // remove file status
        toPersist.removeStatus(file);
        mirror.removeStatus(file);

        toPersist = serializeDeserializeAndTest(serializer, toPersist, mirror);
        toPersist = serializeDeserializeAndTest(serializer, toPersist, mirror);
    }

    private static FileStatus serializeDeserializeAndTest(
            ObjectSerializer serializer, FileStatus toPersist, FileStatus mirror)
            throws Exception {
        serializer.serialize(toPersist);
        toPersist = serializer.deserialize(FileStatus.class);
        test(toPersist, mirror);
        return toPersist;
    }

    private static void test(FileStatus given, FileStatus expected) {
        if (given.equals(expected)) {
            System.out.println("everything is OK");
        } else {
            throw new IllegalArgumentException("Are not the same!");
        }
    }
}

class ObjectSerializer {

    private static final boolean OVERWRITE_MODE = false;

    public <T> void serialize(T instance) throws IOException {
        OutputStream overwriteStream = new FileOutputStream(getFile(instance.getClass()), OVERWRITE_MODE);
        OutputStream bufferedStream = new BufferedOutputStream(overwriteStream);
        ObjectOutputStream objectstream = new ObjectOutputStream(bufferedStream);
        objectstream.writeObject(instance);
        objectstream.close();
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialize(Class<T> clazz) throws Exception {
        InputStream input = new BufferedInputStream(new FileInputStream(getFile(clazz)));
        ObjectInputStream objectStream = new ObjectInputStream(input);
        T instance = (T) objectStream.readObject();
        objectStream.close();
        return instance;
    }

    private <T> File getFile(Class<T> clazz) {
        return new File(clazz.getName());
    }
}

class FileStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    Map<File, Boolean> statusMap = new HashMap<File, Boolean>();

    public void addOrChangeStatus(File file, boolean status) {
        statusMap.put(file, status);
    }

    public void removeStatus(File file) {
        statusMap.remove(file);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((statusMap == null) ? 0 : statusMap.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FileStatus other = (FileStatus) obj;
        if (statusMap == null) {
            if (other.statusMap != null)
                return false;
        } else if (!statusMap.equals(other.statusMap))
            return false;
        return true;
    }
}