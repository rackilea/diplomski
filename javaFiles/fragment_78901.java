public void send(String data) {
        try {
            out.writeUTF(data);
            out.close(); // remove this and replace it with out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }