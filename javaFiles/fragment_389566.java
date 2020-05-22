private static void testAllocFree(final int processId) {
        SIZE_T dwSize = new SIZE_T(1024);

        DWORD  flAllocationType = new DWORD(Kernel32Me.MEM_RESERVE | Kernel32Me.MEM_COMMIT);
        DWORD  flProtect = new DWORD(Kernel32Me.PAGE_READWRITE);
        Pointer allocPoint = null;
        boolean ret = false;
        DWORD options 
            = new DWORD(
                Kernel32Me.PROCESS_VM_OPERATION | 
                Kernel32Me.PROCESS_VM_WRITE | 
                Kernel32Me.PROCESS_VM_READ | 
                Kernel32Me.PROCESS_CREATE_THREAD | 
                Kernel32Me.PROCESS_QUERY_INFORMATION);

        DWORD procs = new DWORD(processId);

        HANDLE hProcess = Kernel32Me.INSTANCE.OpenProcess(options, false, procs);

        if(null == hProcess)
        {
            System.err.println("Can't have a handle for you..sorry");
            return;
        }

        try
        {
            allocPoint = Kernel32Me.INSTANCE.VirtualAllocEx(hProcess, null, dwSize, flAllocationType, flProtect);

            if(allocPoint==null)
            {
                System.err.println("Can't get a memory resource for you..sorry");
                int c = Kernel32Me.INSTANCE.GetLastError();
                System.out.println("\t>>" + c);
                //c = Native.getLastError();
                //System.out.println("\t" + c);
            }

            if (allocPoint != null) {
                dwSize = new SIZE_T(0);
                DWORD freeType = new DWORD(Kernel32Me.MEM_RELEASE);
                System.err.println("allocPoint >>==> " + allocPoint.toString());
                ret = Kernel32Me.INSTANCE.VirtualFreeEx(hProcess, allocPoint, dwSize, freeType);

                if(!ret)
                {
                    int c = Kernel32Me.INSTANCE.GetLastError();
                    System.out.println("\t" + c);
                    c = Native.getLastError();
                    System.out.println("\t" + c);
                }
                else
                {
                    System.out.println("\t Free success");
                }
            }
        }
        finally
        {
            Kernel32Me.INSTANCE.CloseHandle(hProcess);
        }


    }