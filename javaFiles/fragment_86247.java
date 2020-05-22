@ECHO OFF
(ECHO This is line one
ECHO This is line two; the next is empty
ECHO.
ECHO This is line four)| java -cp bin Dump
PAUSE