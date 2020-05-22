@echo off

for /F "tokens=1-2*" %%a in ('findstr /N "^" test.txt') do (
   for /F "tokens=1,2 delims=:/" %%d in ("%%a") do (
      if "%%e" equ "C3" (
         echo %%c
      ) else if "%%e" neq "" (
         echo ; %%e %%b %%c
      ) else (
         echo/
      )
   )
)