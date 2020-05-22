String[] stringCommand = { "bash", "-c", "/usr/bin/sqlldr username/password@sid control=/path/to/sample.ctl"};

Runtime rt = Runtime.getRuntime();
Process proc = null;
try {
    proc = rt.exec(stringCommand);
}catch (Exception e) {
    // TODO something
}finally {
    proc.destroy();
}