private static void testModuleFileName2(final int processId)
    {
        Function allocFunc = Function.getFunction("kernel32", "GetModuleFileName");

        DWORD nSize = new DWORD(256);
        char[] lpFilename = new char[256];

        DWORD procs = new DWORD(processId);
        DWORD options 
            = new DWORD(
                Kernel32Me.PROCESS_VM_READ | 
                Kernel32Me.PROCESS_QUERY_INFORMATION);

        HANDLE hProcess = Kernel32Me.INSTANCE.OpenProcess(options, false, procs);

        if(null == hProcess)
        {
            System.err.println("Can't have a handle for you..sorry");
            return;
        }

        try
        {
            Object[] inArgs = new Object[3];
            inArgs[0] = null;
            inArgs[1] = lpFilename;
            inArgs[2] = nSize;
            allocFunc.invoke(inArgs);
            System.err.println("module path is " + new String(lpFilename));
        }
        finally
        {
            Kernel32Me.INSTANCE.CloseHandle(hProcess);
        }


    }