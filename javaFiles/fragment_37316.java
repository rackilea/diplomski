const
  JavaKey = 'SOFTWARE\JavaSoft\Java Runtime Environment';

function GetJavaVersionAndPath(
   RootKey: Integer; var JavaVersion: string; var JavaPath: string): Boolean;
var
  JREVersion: string;
begin
  Result :=
    RegQueryStringValue(RootKey, JavaKey, 'CurrentVersion', JavaVersion) and
    RegQueryStringValue(RootKey, JavaKey + '\' + JavaVersion, 'JavaHome', JavaPath);
end;

{ ... }
var
  JavaVersion: string;
  JavaPath: string;
begin
  if GetJavaVersionAndPath(HKLM64, JavaVersion, JavaPath) then
  begin
    Log(Format('Java %s 64-bit found in "%s"', [JavaVersion, JavaPath]));
  end
    else
  if GetJavaVersionAndPath(HKLM32, JavaVersion, JavaPath) then
  begin
    Log(Format('Java %s 32-bit found in "%s"', [JavaVersion, JavaPath]));
  end
    else
  begin
     Log('No Java found');
  end;
end;