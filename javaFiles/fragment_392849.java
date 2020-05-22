public abstract class Server<T extends RequestHandler> {

    protected abstract T wrapSocket(Socket socket);

    protected void handleNewConnectionRequest(Socket socket) {
        try {
            executorService.submit(wrapSocket(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}