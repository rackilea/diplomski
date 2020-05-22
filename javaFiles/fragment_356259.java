JFrame frame = new JFrame("Your title here");
JLabel title = new JLabel("Sign in");
JPasswordField userPassword = new JPasswordField(); //changed variable name to userPassword instead of user_password to follow Java naming conventions

frame.add(title, BorderLayout.NORTH);
frame.add(userPassword, BorderLayout.SOUTH);

frame.setVisible(true); //This line should be the last one or you'll find yourself with strange "bugs" when your application starts until you move it or resize it