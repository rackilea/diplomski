final ProcessBuilder pb = new ProcessBuilder("bcp", "dbname..mytable",
    "in", "/home/guest/test",
    "-U", "guest", 
    "-P", "guest",
    "-S", "LXXDB1DO6",
    "-I", "/opt/sybase/08/interfaces",
    "-c",
    "-Y",
    "-t", "|",
    "-r", "\\n"
);
final Process p = pb.start();