Process[] javaProcesses = Process.GetProcessesByName("somejavaapp.exe");
foreach (Process proc in javaProcesses)
{
    ManagementObjectSearcher searcher = new ManagementObjectSearcher(
    "SELECT * " +
    "FROM Win32_Process " +
    "WHERE ParentProcessId=" + proc.Id);

    ManagementObjectCollection collection = searcher.Get();

    // Choose what to do with the child processes.
    foreach (var childProcess in collection)
    {
        var childProcessId = (UInt32)childProcess["ProcessId"];
    }
}