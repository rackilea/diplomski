import System.IO;

function Start() {
   var info:FileInfo = new FileInfo("/Applications/TextEdit.app/Contents/MacOS/TextEdit");
   System.Diagnostics.Process.Start(info.FullName);
}