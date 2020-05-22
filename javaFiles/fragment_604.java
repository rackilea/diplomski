// command line for java.exe in order to start a jar file: java -jar jar_file
var arguments = String.Format(" -jar {0}", jarFile);
// indicate, that you want to capture the application output
process.StartInfo.UseShellExecute = false;
process.StartInfo.RedirectStandardOutput = true;
// create a process instance
var process = new Process();
// and instruct it to start java with the given parameters
var processStartInfo = new ProcessStartInfo(javaExecutable, arguments);
process.StartInfo = processStartInfo;
// start the process
process.Start();
// read the output from the started appplication
string output = process.StandardOutput.ReadToEnd();
process.WaitForExit();