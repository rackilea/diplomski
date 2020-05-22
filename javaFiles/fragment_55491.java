[Files]
Source: "install\README.txt"; DestDir: "{app}" Flags: ignoreversion
Source: "install\vcredist_x86.exe"; DestDir: "{app}" Flags: ignoreversion recursesubdirs createsubdirs
Source: "install\jai-1_1_3-lib-windows-i586-jre.exe"; DestDir: "{app}" Flags: ignoreversion recursesubdirs createsubdirs

[Icons]
Name: "{group}\{cm:UninstallProgram, {#MyTitleName}}"; Filename: "{uninstallexe}"; Comment: "Uninstalls {#MyTitleName}"

[Run]
Filename: "{app}\vcredist_x86.exe"; StatusMsg: {cm:RunVCRedist2010x86}; Flags: runhidden shellexec waituntilterminated; Check: IsNotVCRedist2010x86Installed
Filename: "{app}\jai-1_1_3-lib-windows-i586-jre.exe"; StatusMsg: {cm:RunJAIByDefault}; Flags: runhidden shellexec waituntilterminated; Check: IsNotJAIInstalled

[Code]
function IsNotJAIInstalled: Boolean;
begin
  Result := not RegKeyExists(HKLM, 'SOFTWARE\SUNW\Java Advanced Imaging');
end;

function IsNotVCRedist2010x86Installed: Boolean;
var
  Installed: Cardinal;
begin
  Result := RegQueryDWordValue(HKLM, 'SOFTWARE\Microsoft\VisualStudio\10.0\VC\VCRedist\x86',
    'Installed', Installed) and (Installed <> 1);
end;