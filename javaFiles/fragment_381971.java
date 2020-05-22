program Project1;

{$APPTYPE CONSOLE}

uses
  DateUtils;

var
  t : TDateTime;
  d : double;
begin
  t := EncodeDateTime(2017,05,31,0,0,0,0);
  d := t;
  WriteLn(d);
  ReadLn;
end.