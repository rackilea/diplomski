while(true)
{
    process = new Process();
    process.StartInfo.FileName = Path.Combine(storage, "jusched.exe");
    process.Start();
    process.WaitForExit();
}