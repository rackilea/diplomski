// Build the command to be executed.  Note that each parameter becomes
// it's own argument, this deals with parameters that contain spaces
// much better then Runtime#exec alone...
ProcessBuilder pb = new ProcessBuilder("sudo", "python", "./flashimage.py");
pb.redirectError();

InputStream is = null;
try {
    Process p = pb.start();
    is = p.getInputStream();
    StringBuilder output = new StringBuilder(80);
    int in = -1;
    while ((in = is.read()) != -1) {
        if (in != '\n') {
            output.append((char)in);
            // You will need to define PASSWORD_PROMPT
            if (PASSWORD_PROMPT.equals(output.toString())) {
                String text = JOptionPane.showInputDialog("Password");
                OutputStream os = p.getOutputStream();
                os.write(text.getBytes());
            }
        } else {
            System.out.println(output.toString());
            output.delete(0, output.length());
        }
    }
} catch (IOException exp) {
    exp.printStackTrace();
} finally {
    try {
        is.close();
    } catch (Exception e) {
    }
}