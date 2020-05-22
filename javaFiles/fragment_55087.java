import System.Diagnostics;

var fileLocation: String = "C:/Program Files/Skype/Phone/Skype.exe";
var test:Process = new Process();
test.StartInfo.FileName = fileLocation;
function Start() {
   test.Start();
   UnityEngine.Debug.Log("we got here!");
}