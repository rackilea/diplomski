String[] cmd = { 
    "cmd.exe", 
    "/c", 
    "start", 
    "/wait", 
    "setup",
    "/z\"/sfC:\\temp\\input_file.txt\"", 
    "/s",
    "/f2\"C:\\temp\\newlogfile.log\"" 
};

Runtime.getRuntime().exec(cmd);