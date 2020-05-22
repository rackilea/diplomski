Dim shell, foppath, workpath
Set shell = Server.CreateObject("WScript.Shell")

foppath = Server.MapPath("/fop/")
workpath = Server.MapPath("/tmp/")
shell.CurrentDirectory = foppath

Dim commandline
commandline = "java -Denv.windir=C:\WINDOWS   -cp """
'set classpath
commandline = commandline & foppath & "\build\fop.jar;"
commandline = commandline & foppath & "\build\fop-sandbox.jar;"
commandline = commandline & foppath & "\build\fop-hyph.jar;"
commandline = commandline & foppath & "\lib\xml-apis-1.3.04.jar;"
commandline = commandline & foppath & "\lib\xml-apis-ext-1.3.04.jar;"
commandline = commandline & foppath & "\lib\xercesImpl-2.7.1.jar;"
commandline = commandline & foppath & "\lib\xalan-2.7.0.jar;"
commandline = commandline & foppath & "\lib\serializer-2.7.0.jar;"
commandline = commandline & foppath & "\lib\batik-all-1.7.jar;"
commandline = commandline & foppath & "\lib\xmlgraphics-commons-1.3.1.jar;"
commandline = commandline & foppath & "\lib\avalon-framework-4.2.0.jar;"
commandline = commandline & foppath & "\lib\commons-io-1.3.1.jar;"
commandline = commandline & foppath & "\lib\commons-logging-1.0.4.jar;"
commandline = commandline & foppath & "\lib\jai_imageio.jar;"
commandline = commandline & foppath & "\lib\fop-hyph.jar;"
commandline = commandline & """ org.apache.fop.cli.Main "
commandline = commandline & workpath & "/file.fo "
commandline = commandline & workpath & "/file.pdf "

Dim ResultCode
ResultCode = Shell.Run(commandline,,True) ' True = Wait for FOP to finish