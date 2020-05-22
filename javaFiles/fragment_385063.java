@echo off
setlocal enabledelayedexpansion

set _classpath=.
for %%i in (%1/lib/*.*) do (
    set _classpath=!_classpath!;%%i
)

echo %_classpath%
pause