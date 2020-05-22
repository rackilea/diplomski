Set objShell = WScript.CreateObject("WScript.Shell")
objShell.Run "C:\Program Files\Java\jre[version number]\bin\java.exe C:\DVRJavaView4.1.jar"
Do Until Success = True
    Success = objShell.AppActivate("java")
    Wscript.Sleep 1000
Loop
objShell.SendKeys "millapt.ddns.specoddns.net"
objShell.SendKeys "{ENTER}"
Wscript.Sleep 1000
objShell.SendKeys "user"
objShell.SendKeys "{TAB}"
Wscript.Sleep 1000
objShell.SendKeys "4321"
objShell.SendKeys "{ENTER}"
Wscript.Sleep 1000
objShell.SendKeys "{ENTER}"