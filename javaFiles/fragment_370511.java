@Override
public void run() {
    try {
        while (true) {
            mySocket = ss.accept();
            dis = new DataInputStream(mySocket.getInputStream());

            try {
                while (true) {
                    message = dis.readUTF();
                    handler.post(() -> {
                        bufferIntentSendCode.putExtra("data", message);
                        ctx.sendBroadcast(bufferIntentSendCode);
                    });
                }
            } catch (IOException e) {
            }

            dis.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}