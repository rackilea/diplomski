...
Series1.OnGetMarkText := Self.Series1GetMarkText;  // Define the OnGetMarkText event
...

procedure TMyForm.Series1GetMarkText(Sender: TChartSeries;
  ValueIndex: Integer; var MarkText: string);
begin
  if ValueIndex=3 then  // Just an example how to set the selection criteria 
    MarkText := 'Hello'
  else
    MarkText := '';
end;