String[] command = {"ls", "-s"}; // Mention your list of commands here

  StringBuilder cmdReturn = new StringBuilder();

  try {
   ProcessBuilder processBuilder = new ProcessBuilder(command);
   Process process = processBuilder.start();

   InputStream inputStream = process.getInputStream();
   int c;
            while ((c = inputStream.read()) != -1) {
                cmdReturn.append((char) c);
            }

            prompt.setText(cmdReturn.toString());

  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }