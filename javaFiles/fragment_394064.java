InputStream is = null;
try {
    is = MainClient.getProcess().getInputStream();
    int in = -1;
    while ((in = is.read()) != -1) {
        System.out.print(((char)in));
    }
} catch (IOException exp) {
    exp.printStackTrace();
} finally {
    try {
        is.close();
    } catch (Exception exp) {
    }
}