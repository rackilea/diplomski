PrintWriter out = null;
try {
     out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
} catch (IOException e) {
     e.printStackTrace();
}
out.println(messageToServer);
out.flush();