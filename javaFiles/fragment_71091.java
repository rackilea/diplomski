// Setting console to raw mode
String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
Runtime.getRuntime().exec(cmd).waitFor();

// Getting input stream
Console console = System.console();
Reader reader = console.reader();

// Checking if input is ^C
char c=0;
while(c!=3) { // 3 = ^C
    c=(char)reader.read();
}
// ^C is entered

// Reset console to normal mode
cmd = new String[] {"/bin/sh", "-c", "stty sane </dev/tty"};
Runtime.getRuntime().exec(cmd).waitFor();   

// Initialize frame
JFrame frame = new JFrame();
frame.setDefaultCloseOperation(3);
frame.setSize(400,200);
frame.setLocationRelativeTo(null);
frame.setTitle("Why are you leaving me ?");
frame.setVisible(true);