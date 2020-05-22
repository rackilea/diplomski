private static void testModuleFileName(final int processId)
    {
        DWORD nSize = new DWORD(256);
        char lpFilename[] = new char[256];
        byte bFilename[] = new byte[256];
        String strFileName = new String();
        DWORD options = new DWORD(Kernel32Me.PROCESS_VM_READ | Kernel32Me.PROCESS_QUERY_INFORMATION);
        DWORD procs = new DWORD(processId);

        HANDLE hProcess = Kernel32Me.INSTANCE.OpenProcess(options,false, procs);

        if(null == hProcess)
        {
            System.err.println("Can't have a handle for you..sorry");
            return;
        }

        try
        {
            Kernel32Me.INSTANCE.GetModuleFileName(null, lpFilename, nSize);
            System.err.println("module path is " + new String(lpFilename));

            Kernel32Me.INSTANCE.GetModuleFileName(null, bFilename, nSize);
            System.err.println("module path is " + new String(bFilename));

            Kernel32Me.INSTANCE.GetModuleFileNameEx(hProcess, null, strFileName, nSize);
            System.err.println("module path is " + strFileName);

        }
        finally
        {
            Kernel32Me.INSTANCE.CloseHandle(hProcess);
        }
    }