static boolean is64bitProcess() {
    String wow64_kernel = System.getenv("systemroot") + "\\SysWOW64\\kernel32.dll";
    if (new File(wow64_kernel).exists()) {
        try {
            System.load(wow64_kernel);
        } catch (UnsatisfiedLinkError e) {
            return true; // can not link 32-bit library into 64-bit process
        }
    }
    return false;
}