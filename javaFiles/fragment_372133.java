String[] cmd = {
"/bin/sh",
"-c",
"dir | grep gpc | grep -v 25"
};

Process p = Runtime.getRuntime().exec(cmd);