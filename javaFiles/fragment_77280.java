function GetJavaVersion2: string;
var
  TempFile: string;
  ResultCode: Integer;
  S: AnsiString;
  P: Integer;
begin
  TempFile := ExpandConstant('{tmp}\javaversion.txt');
  if (not ExecAsOriginalUser(
            ExpandConstant('{cmd}'), '/c java -version 2> "' + TempFile + '"', '',
            SW_HIDE, ewWaitUntilTerminated, ResultCode)) or
     (ResultCode <> 0) then
  begin
    Log('Failed to execute java -version');
  end
    else
  if not LoadStringFromFile(TempFile, S) then
  begin
    Log(Format('Error reading file %s', [TempFile]));
  end
    else
  if Copy(S, 1, 14) <> 'java version "' then
  begin
    Log('Output of the java -version not as expected');
  end
    else
  begin
    Delete(S, 1, 14);
    P := Pos('"', S);
    if P = 0 then
    begin
      Log('Output of the java -version not as expected');
    end
      else
    begin
      SetLength(S, P - 1);
      Result := S;
    end;
  end;

  DeleteFile(TempFile);
end;