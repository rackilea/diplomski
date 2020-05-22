@Override
public void run() {
    try {
        while (true) {
            mySocket = ss.accept();
            dis = new DataInputStream(mySocket.getInputStream());

            try {
                // maybe other things first...

                int length = dis.readInt();
                for (int i = 0; i < length; ++i) {
                    message = dis.readUTF();
                    handler.post(() -> {
                        bufferIntentSendCode.putExtra("data", message);
                        ctx.sendBroadcast(bufferIntentSendCode);
                    });
                }

                // maybe other things next...

            } catch (IOException e) {
            }

            dis.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}