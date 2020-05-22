/*
 * This thread is used for writing content which will be read by native code using STDIN.
 */
new Thread(new Runnable() {

    @Override
    public void run() {
        BufferedWriter out = null;
        try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mInfile)));
            String content = "This content is written to " + mInfile;
            out.write(content.toCharArray(), 0, content.toCharArray().length);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}).start();