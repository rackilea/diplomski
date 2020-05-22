Dictionary<IntPtr, string> processArguments = new Dictionary<IntPtr,string>();

        ProcessStartInfo startInfo = new ProcessStartInfo();
        startInfo.FileName = javahome + "\\bin\\java.exe";
        startInfo.Arguments = "-jar Example.jar port=88888";
        startInfo.WorkingDirectory = "\\testFolder";
        startInfo.UseShellExecute = false;
        startInfo.CreateNoWindow = true;
        Process proc = new Process();
        proc.StartInfo = startInfo;
        proc.Start();

        processArguments.Add(proc.Handle, javahome + "\\bin\\java.exe");

....

        Process[] processes = Process.GetProcessesByName("java");
        foreach (Process proc in processes)
        {
            var arguments = processArguments.Where(x => x.Key.Equals(proc.Handle)).FirstOrDefault().Value;
        }