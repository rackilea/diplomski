public void onClick(View view) {
 String command = null;
 switch (view.getId()) {
      case R.id.button1:
        command = "w";
        break;
      case R.id.button2:
        command = "a";
        break;
      case R.id.button3:
        command = "d";
        break;
      case R.id.button4:
        command = "s";
        break;
  }

  try {
     PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())),
                        true);                    
     out.println(command);
  } catch (UnknownHostException e) {
     e.printStackTrace();
  } catch (IOException e) {
     e.printStackTrace();
  } catch (Exception e) {
     e.printStackTrace();
  }
}