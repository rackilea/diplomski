private static void printProcesses()
    {
        Tlhelp32.PROCESSENTRY32.ByReference processEntry = new Tlhelp32.PROCESSENTRY32.ByReference();

        HANDLE snapshot = Kernel32Me.INSTANCE.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS,
                new DWORD(0));
        try {
            while (Kernel32Me.INSTANCE.Process32Next(snapshot, processEntry)) {
                System.out.println(processEntry.th32ProcessID + "\t" + Native.toString(processEntry.szExeFile));
            }
        } finally {
            Kernel32Me.INSTANCE.CloseHandle(snapshot);
        }
    }