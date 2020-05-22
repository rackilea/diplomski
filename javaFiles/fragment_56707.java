String python= "D:\home\python362x86\python.exe";
String pythonScriptPath = "D:\home\site\wwwroot\ProcessFile\NLP.py";
String[] cmd = new String[3];
cmd[0] = "python"; // check version of installed python: python -V
cmd[1] = pythonScriptPath;
cmd[2]="playing sport";
// create runtime to execute external command
Runtime rt = Runtime.getRuntime();
Process pr = rt.exec(cmd);