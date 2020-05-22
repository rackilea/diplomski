Set Serverout On
Declare
comm Varchar2(2000);
Begin
comm := OSCommand_Run('/home/jguy/runJavaApp.sh')--for calling commands
DBMS_OUTPUT.Put_Line(comm);
End;