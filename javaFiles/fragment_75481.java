// Initialize a ConnBean object, parameter list is ip, username, password
ConnBean cb = new ConnBean("ip ", "username","password");
// Put the ConnBean instance as parameter for SSHExec static method getInstance(ConnBean) to retrieve a singleton SSHExec instance
ssh = SSHExec.getInstance(cb);          
// Connect to server
ssh.connect();
CustomTask sampleTask = new ExecCommand("echo 123");
ssh.exec(sampleTask);