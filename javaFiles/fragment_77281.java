function InitializeSetup(): Boolean;
var
  ErrorCode: Integer;
begin
  Result := HasJava1Dot7OrNewer;
  if not Result then
  begin
    Result := MsgBox(ExpandConstant('{cm:JavaRequired}'), mbConfirmation, MB_YESNO) = idYes;
    if Result then
    begin
      ShellExec(
        'open', 'https://www.java.com/getjava/', '', '', SW_SHOWNORMAL, ewNoWait, ErrorCode);
    end;
  end;
end;