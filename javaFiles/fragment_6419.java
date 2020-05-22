public class RedirectStreams {
public RedirectStreams(Process process1, Process process2) {
    final Process tmpProcess1 = process1;
    final Process tmpProcess2 = process2;
    new Thread(new Runnable() {
        @Override
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(tmpProcess1.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(tmpProcess2.getOutputStream()));
            String lineToPipe;

            try {

                while ((lineToPipe = bufferedReader.readLine()) != null){
                    System.out.println("Output process1 / Input process2:" + lineToPipe);
                    bufferedWriter.write(lineToPipe + '\n');
                    bufferedWriter.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }).start();
}

}