const
  UnixStartDate = 25569.0;

function DateTimeToUnixTime(const ADateTime: TDateTime): Cardinal;
begin
  Result := Round(ADateTime - UnixStartDate) * 86400;
end;

function UnixTimeToDateTime(const UnixDate: Cardinal): TDateTime;
begin
  Result := UnixDate / 86400 + UnixStartDate;
end;

procedure TForm1.Button1Click(Sender: TObject);
var  StartDate: TDateTime;
  UnixDate: Cardinal;
begin
  StartDate := Date();
  Memo1.Lines.Add('Start Date: ' + DateToStr(StartDate));
  UnixDate := DateTimeToUnixTime(StartDate);
  Memo1.Lines.Add('DateTimeToUnixTime = ' + IntToStr(UnixDate));
  Memo1.Lines.Add('UnixTimeToDateTime = ' + DateToStr(UnixTimeToDateTime(UnixDate)));
end;