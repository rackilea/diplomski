ProcessStartInfo psi = new ProcessStartInfo("jps", "-v");
        psi.RedirectStandardOutput = true;
        psi.UseShellExecute = false;
        Process p = new Process();
        p.StartInfo = psi;
        p.Start();
        string[] output = p.StandardOutput.ReadToEnd().Split("\n".ToCharArray());