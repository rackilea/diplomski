miner = new Process{
    StartInfo = new ProcessStartInfo {
        FileName = "java.exe",
        Arguments = "-cp \"libs\\*;DiabloMiner.jar\" -Djava.library.path=libs\\natives com.diablominer.DiabloMiner.DiabloMiner -u '" + this.user + "' -p '" + this.password + "' -o '" + this.server + "'",
        WorkingDirectory = Directory.GetCurrentDirectory();
        UseShellExecute = false,
        RedirectStandardOutput = true,
        RedirectStandardError = true,
        CreateNoWindow = true
    }
};
miner.Start();
miner.WaitForExit();
string output = miner.StandardOutput.ReadToEnd();
string error = miner.StandardError.ReadToEnd();
// Display "output" and "error" however you like