@set @Batch=1    /*
@cscript //nologo //E:JScript "%~F0" < test.txt
@goto :EOF & rem */

WScript.Stdout.Write(WScript.Stdin.ReadAll().replace
   (/^C3\/.{15}|^(..)/gm,function(A){return A.length==2?"; "+A:""}));