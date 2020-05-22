function WinInetErrorMsg(Err: DWORD): string;
var
  ErrMsg: array of Char;
  ErrLen: DWORD;
begin
  if Err = ERROR_INTERNET_EXTENDED_ERROR then
  begin
    ErrLen := 0;
    InternetGetLastResponseInfo(Err, nil, ErrLen);
    if GetLastError() = ERROR_INSUFFICIENT_BUFFER then
    begin
      SetLength(ErMsg, ErrLen);
      InternetGetLastResponseInfo(Err, PChar(ErMsg), ErrLen);
      SetString(Result, PChar(ErrMsg), ErrLen);
    end else begin
      Result := 'Unknown WinInet error';
    end;
  end else
    Result := SysErrorMessage(Err);
end;

function TFormMain.JSONPostRequest(const Server, Url: string; const jo : UTF8String; blnSSL: Boolean): String;
var
  aBuffer     : Array of Byte;
  Header      : String;
  BufStream   : TStringStream;
  BytesRead   : DWORD;
  pSession    : HINTERNET;
  pConnection : HINTERNET;
  pRequest    : HINTERNET;
  port        : Integer;
  flags       : DWORD;
begin
  Result := '';
  pSession := InternetOpen(nil, INTERNET_OPEN_TYPE_PRECONFIG, nil, nil, 0);
  if not Assigned(pSession) then
    raise Exception.Create('InternetOpen failed. ' + WinInetErrorMsg(GetLastError));
  try
    if blnSSL then
      Port := INTERNET_DEFAULT_HTTPS_PORT
    else
      Port := 9000;
    pConnection := InternetConnect(pSession, PChar(Server), port, nil, nil, INTERNET_SERVICE_HTTP, 0, 0);
    if not Assigned(pConnection) then
      raise Exception.Create('InternetConnect failed. ' + WinInetErrorMsg(GetLastError));
    try
      if blnSSL then
        flags := INTERNET_FLAG_SECURE
      else
        flags := 0;
      pRequest := HTTPOpenRequest(pConnection, 'POST', PChar(Url), nil, nil, nil, flags, 0);
      if not Assigned(pRequest) then
        raise Exception.Create('HttpOpenRequest failed. ' + WinInetErrorMsg(GetLastError));
      try
        Header := 'Host: ' + Server + ':' + IntToStr(Port) + #13#10 +
                  'Content-Type: application/json; charset=UTF-8'#13#10;

        if not HttpAddRequestHeaders(pRequest, PChar(Header), Length(Header), HTTP_ADDREQ_FLAG_ADD) then
          raise Exception.Create('HttpAddRequestHeaders failed. ' + WinInetErrorMsg(GetLastError));

        if not HTTPSendRequest(pRequest, nil, 0, PAnsiChar(jo), Length(jo)) then
          raise Exception.Create('HTTPSendRequest failed. ' + WinInetErrorMsg(GetLastError));

        SetLength(aBuffer, 4096);
        BufStream := TStringStream.Create('', TEncoding.Default);
        try
          repeat
            if not InternetReadFile(pRequest, PByte(aBuffer), Length(aBuffer), BytesRead) then
              raise Exception.Create('InternetReadFile failed. ' + WinInetErrorMsg(GetLastError));
            if (BytesRead = 0) then Break;
            BufStream.WriteBuffer(PByte(aBuffer)^, BytesRead);
          until False;
          Result := BufStream.DataString;
        finally
          BufStream.Free;
        end;
      finally
        InternetCloseHandle(pRequest);
      end;
    finally
      InternetCloseHandle(pConnection);
    end;
  finally
    InternetCloseHandle(pSession);
  end;
end;