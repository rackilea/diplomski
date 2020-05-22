public class ProcessPipeTest {
@Test public void testPipe(){
    try {

        Process process1 = new ProcessBuilder("/bin/bash").start();
        Process process2 = new ProcessBuilder("/bin/bash").start();

        RedirectStreams redirectStreams = new RedirectStreams(process1,process2);


        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process1.getOutputStream()));
        String command = "echo echo echo";
        System.out.println("Input process1: " + command);
        bufferedWriter.write(command + '\n');
        bufferedWriter.close();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process2.getInputStream()));
        String actualOutput = bufferedReader.readLine();
        System.out.println("Output process2: " + actualOutput);
        assertEquals("echo",actualOutput);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}