private static void testCopyFile() {
        Function copyFunc = Function.getFunction("kernel32", "CopyFileA");
        Object[] params = new Object[3];
        params[0] = "C:\\DEV\\temp\\_info.txt";
        params[1] = "C:\\DEV\\temp\\_info2.txt";
        params[2] = false;
        copyFunc.invoke(params);
    }