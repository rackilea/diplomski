public class Main {

public static void main(String[] args) {
    try {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter File name: ");
        String str = bf.readLine();
        File file = new File(str);
        //File length
        int size = (int) file.length();
        if (size > Integer.MAX_VALUE) {
            System.out.println("File is to larger");
        }
        byte[] bytes = new byte[size];
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int read = 0;
        int numRead = 0;
        while (read < bytes.length && (numRead = dis.read(bytes, read,
                bytes.length - read)) >= 0) {
            read = read + numRead;
        }
        dis.close();

        DataOutputStream out = new DataOutputStream(new FileOutputStream(new File("c:\\out.pdf")));
        out.write(bytes);
        out.close();
        System.out.println("File size: " + read);

        // Ensure all the bytes have been read in
        if (read < bytes.length) {
            System.out.println("Could not completely read: " + file.getName());
        }
    } catch (Exception e) {
        e.getMessage();
    }
}