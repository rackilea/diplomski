public static void sendFile(String path) throws IOException {
        try {
            socket = new Socket("127.0.0.1", 8080);
            System.out.println("Connected");
            File file = new File(path);
            InputStream fileInputStream = new FileInputStream(file);
            OutputStream fileOutputStream = socket.getOutputStream();
            byte[] bytes = new byte[16 * 1024];
            int count;
            while ((count = fileInputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, count);
            }
            fileOutputStream.close();
            fileInputStream.close();
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        } finally {
            try {
                 socket.close();
            } catch (IOException i) {
                System.out.println(i);
            }
        }
    }