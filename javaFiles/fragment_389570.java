public interface Kernel32Me extends StdCallLibrary {
        final Kernel32Me INSTANCE 
            = (Kernel32Me) Native.loadLibrary("kernel32.dll", Kernel32Me.class, W32APIOptions.DEFAULT_OPTIONS);

        //https://msdn.microsoft.com/en-us/library/windows/desktop/aa366890(v=vs.85).aspx
        int PROCESS_CREATE_THREAD = 0x0002;
        int PAGE_EXECUTE_READWRITE = 0x40;
        int PROCESS_QUERY_INFORMATION = 0x0400;
        int PROCESS_VM_OPERATION = 0x0008;
        int PROCESS_VM_WRITE = 0x0020;
        int PROCESS_VM_READ = 0x0010;
        int PAGE_READWRITE = 0x04;
        int MEM_RESERVE = 0x00002000;
        int MEM_COMMIT = 0x00001000;
        int MEM_RESET = 0x00080000;
        int MEM_DECOMMIT = 0x4000;
        int MEM_RELEASE = 0x8000;


        Pointer VirtualAllocEx(HANDLE hProcess, Pointer lpAddress, SIZE_T dwSize, DWORD flAllocationType, DWORD flProtect);

        boolean VirtualFreeEx(HANDLE hProcess, Pointer lpAddress, SIZE_T dwSize, DWORD dwFreeType);

        DWORD GetModuleFileName(HMODULE hModule, char[] lpFilename, DWORD nSize);
        DWORD GetModuleFileName(HMODULE hModule, byte[] lpFilename, DWORD nSize);
        DWORD GetModuleFileNameEx(HANDLE hProcess, HMODULE hModule, String lpFilename, DWORD nSize);

        HANDLE CreateToolhelp32Snapshot(DWORD dwFlags, DWORD th32ProcessID);

        boolean Process32First(HANDLE hSnapshot, PROCESSENTRY32 lppe);

        boolean Process32Next(HANDLE hSnapshot, PROCESSENTRY32 lppe);

        HANDLE OpenProcess(DWORD dwDesiredAccess, boolean bInheritHandle, DWORD dwProcessId);

        boolean CloseHandle(HANDLE hObject);

        int GetLastError();
    }