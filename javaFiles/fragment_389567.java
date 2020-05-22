private static void testAllocFree2(final int processId) {
        Function allocFunc = Function.getFunction("kernel32", "VirtualAllocEx");
        Function freeFunc = Function.getFunction("kernel32", "VirtualFreeEx");
        DWORD  flAllocationType = new DWORD(Kernel32Me.MEM_RESERVE | Kernel32Me.MEM_COMMIT);
        DWORD  flProtect = new DWORD(Kernel32Me.PAGE_READWRITE);
        SIZE_T dwSize = new SIZE_T(1024);

        DWORD freeType = new DWORD(Kernel32Me.MEM_RELEASE);
        DWORD options 
            = new DWORD(
                Kernel32Me.PROCESS_VM_OPERATION | 
                Kernel32Me.PROCESS_VM_WRITE | 
                Kernel32Me.PROCESS_VM_READ | 
                Kernel32Me.PROCESS_CREATE_THREAD | 
                Kernel32Me.PROCESS_QUERY_INFORMATION);

        DWORD procs = new DWORD(processId);

        Pointer allocPoint = null;

        HANDLE hProcess = Kernel32Me.INSTANCE.OpenProcess(options, false, procs);

        if(null == hProcess)
        {
            System.err.println("Can't have a handle for you..sorry");
            return;
        }

        Object[] inArgs = new Object[5];
        inArgs[0] = hProcess;
        inArgs[1] = null;
        inArgs[2] = dwSize;
        inArgs[3] = flAllocationType;
        inArgs[4] = flProtect;

        allocPoint = (Pointer) allocFunc.invoke(Pointer.class, inArgs);

        try
        {
            if(allocPoint==null)
            {
                System.err.println("Can't get a memory resource for you..sorry");
                int c = Kernel32Me.INSTANCE.GetLastError();
                System.out.println("\t>>" + c);
                //c = Native.getLastError();
                //System.out.println("\t" + c);
            }

            if (allocPoint != null) {
                Object[] inArgs2 = new Object[4];
                inArgs2[0] = hProcess;
                inArgs2[1] = allocPoint;
                inArgs2[2] = new SIZE_T(0);
                inArgs2[3] = freeType;
                System.err.println("allocPoint ==> " + allocPoint.toString());
                freeFunc.invoke(inArgs2);
            }
        }
        finally
        {
            Kernel32Me.INSTANCE.CloseHandle(hProcess);
        }
    }