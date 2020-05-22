@echo off
setlocal

:: if java.exe is not in %path%
for %%I in (java.exe) do if "%%~$PATH:I" equ "" (
    set "PATH=%PATH%;C:\Program Files\Java\jre7\bin;C:\Program Files (x86)\Java\jre7\bin"
)

echo E:\Run.xml| java -jar E:\ER\er_v.3.3.17.jar