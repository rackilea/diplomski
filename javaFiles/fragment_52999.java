var
    sl: TStringList;
begin
    sl := TStringList.Create;
    try
        sl.Add('key1=this''s done');
        sl.Add('key2=that costs 10 dollars');
        sl.Add('key3=number=10');
        ShowMessage(sl.Values['key3']); // Displays number=10
    finally
        sl.Free;
    end;
end;