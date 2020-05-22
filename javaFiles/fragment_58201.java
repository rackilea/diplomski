import java.io.*;
import java.lang.reflect.Field;
import org.junit.Test;
import static org.junit.Assert.*;
public class CloneSerializableTest2 {
    // library classes
        public static class A implements Serializable {
            public transient String s1;
        }

        public static class MyA extends A {

            public String s2;
        }


    private static class AHolder implements Serializable, Externalizable {
        private static final Field s1Fld;
        static {
            try {
                s1Fld = A.class.getDeclaredField("s1");
                s1Fld.setAccessible(true);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException("Unexpected error", e);
            }
        }
        private String s1;
        private A a;

        @SuppressWarnings("unused")
        public AHolder() {
        }
        public AHolder(A m) {
            this.a = m;
            try {
                s1 = (String)s1Fld.get(m);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unexpected error", e);
            }
        }

        private Object readResolve() {
            try {
                s1Fld.set(a, s1);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unexpected error", e);
            }
            return a;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(s1);
            ObjectOutputStream out2 = ((ObjectOutputStream)out);
            out2.writeUnshared(a);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            s1 = (String)in.readObject();
            a = (A)in.readObject();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T cloneSerializable(T o) {
        try {

            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout)
            {
                {
                    enableReplaceObject(true);
                }
                @Override
                protected Object replaceObject(Object obj) throws IOException
                {
                    if (obj instanceof A) {
                        obj = new AHolder((A) obj);
                    } else if (obj instanceof AHolder) {
                        obj = ((AHolder)obj).a;
                    }
                    return super.replaceObject(obj);
                }
            };

            out.writeObject(o);

            out.close();
            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bin);
            Object copy = in.readObject();

            in.close();
            return (T)copy;
        } catch (IOException e) {
            throw new RuntimeException("Unexpected error", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unexpected error", e);
        }
    }
    @Test
    public void testIt() throws Exception {
        try {
        MyA m1 = new MyA();
        m1.s1 = "a";
        m1.s2 = "b";

        m1 = cloneSerializable(m1);
        assertEquals("a", m1.s1);
        assertEquals("b", m1.s2);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}