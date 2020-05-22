Process lsProcess = Runtime.getRuntime().exec("ls");
BufferedReader lsOutput = new BufferedReader(new InputStreamReader(lsProcess.getInputStream()));
Process grepProcess = Runtime.getRuntime().exec("grep build.xml");
BufferedWriter grepInput = new BufferedWriter(new OutputStreamWriter(grepProcess.getOutputStream()));

String line;
// read each line from ls until there are no more
while ((line = lsOutput.readLine()) != null) {
    // and send them to grep
    grepInput.write(line);
    grepInput.newLine();
}

// send end-of-file signal to grep so it will terminate itself
grepInput.close();