String[] command  = new String[] {
    "path/executeScript",
    "--path=" + p,
    "--user=" + user,
    "--html=\"anchor bold\"",
    "--port=8081"
}
Runtime.getRuntime().exec(command);