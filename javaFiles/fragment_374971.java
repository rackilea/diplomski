function next(): Boolean;
  var
    nonzero, last: integer;
  begin
    last := C[n - 1];
    if last = x then  // the last composition
      Exit(False);

    C[n - 1] := 0;
    nonzero := n - 2;
    while C[nonzero] = 0 do //find the last nonzero element
       Dec(nonzero);

    Dec(C[nonzero]);
    C[nonzero + 1] := 1 + last;
    Exit(True);
   end;

begin
  n := 4;
  x := 3;
  SetLength(C, n);
  C[0] := x;
  Memo1.Lines.Add(ArrToStr(C));
  while next() do
    Memo1.Lines.Add(ArrToStr(C));