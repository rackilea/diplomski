public class RemoveLine {
    public static void main(String[] args) throws IOException {
        // Use a random access file
        RandomAccessFile file = new RandomAccessFile(args[0], "rw");
        int counter = 0, target = Integer.parseInt(args[1]);
        long offset = 0, length = 0;

        while (file.readLine() != null) {
            counter++;
            if (counter == target)
                break; // Found target line's offset
            offset = file.getFilePointer();
        }

        length = file.getFilePointer() - offset;

        if (target > counter) {
            file.close();
            throw new IOException("No such line!");
        }

        byte[] buffer = new byte[4096];
        int read = -1; // will store byte reads from file.read()
        while ((read = file.read(buffer)) > -1){
            file.seek(file.getFilePointer() - read - length);
            file.write(buffer, 0, read);
            file.seek(file.getFilePointer() + length);
        }
        file.setLength(file.length() - length); //truncate by length
        file.close();
    }
}