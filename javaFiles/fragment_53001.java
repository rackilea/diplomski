var
    sl: TStringList;
begin
    sl := TStringList.Create;
    try
        // Select a separater you are sure will never be used
        sl.NameValueSeparator := '|';

        sl.Values['maleConsumer=john'] := '1';
        sl.Values['maleConsumer=eric'] := '2';
        sl.Values['femaleConsumer=mary'] := '2';
        sl.Values['maleConsumer=john'] := '8';

        ShowMessage(sl.Values['maleConsumer=john']); // Displays 8
    finally
        sl.Free;
    end;
end;