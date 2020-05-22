System.out.println(GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode().getWidth() + "x" + GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode().getHeight());

//Ignore this block, it was simply to give me a chance to change my resolution
Scanner readUserInput=new Scanner(System.in);
System.out.println("Waiting on input, go change your resolution");
String myName=readUserInput.nextLine();

System.out.println(GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode().getWidth() + "x" + GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode().getHeight());