Result res = ssh.exec(task); 
if (res.isSuccess) {
    System.out.println("Return code: " + res.rc);
    System.out.println("sysout: " + res.sysout);
} else {
    System.out.println("Return code: " + res.rc);
    System.out.println("error message: " + res.error_msg);
}