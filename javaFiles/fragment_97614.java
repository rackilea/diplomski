public class Holder implements Serializable {
    Runnable r;
}
public class Defining {
    public static Holder get() {
        final Holder holder = new Holder();
        holder.r=(Runnable&Serializable)()->{};
        return holder;
    }
}
public class Writing {
    static final File f=new File(System.getProperty("java.io.tmpdir"), "x.ser");
    public static void main(String... arg) throws IOException {
        try(FileOutputStream os=new FileOutputStream(f);
            ObjectOutputStream   oos=new ObjectOutputStream(os)) {
            oos.writeObject(Defining.get());
        }
        System.out.println("written to "+f);
    }
}
public class Reading {
    static final File f=new File(System.getProperty("java.io.tmpdir"), "x.ser");
    public static void main(String... arg) throws IOException, ClassNotFoundException {
        try(FileInputStream is=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(is)) {
            Holder h=(Holder)ois.readObject();
            System.out.println(h.r);
            h.r.run();
        }
        System.out.println("read from "+f);
    }
}