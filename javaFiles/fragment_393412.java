procedure RequestDeliveryDate;
var
  IdHTTP: TIdHTTP;
  LHandler: TIdSSLIOHandlerSocketOpenSSL;
  requestURL, query, lResponse: String;
  //url: TIdURI;
begin
  requestURL := 'https://api.auspost.com.au/DeliveryDates.xml';
  query := '?fromPostcode=2000' +
           '&toPostcode=3000' +
           '&networkId=01' +
           '&lodgementDate=2018-02-23' +
           '&numberOfDates=01';

  try
    IdHTTP := TIdHTTP.Create;
    try
      IdHTTP.Request.BasicAuthentication := True;
      IdHTTP.Request.Username := 'your api username';
      IdHTTP.Request.Password := 'your api password';

      IdHTTP.Request.CustomHeaders.AddValue('Cookie', 'OBBasicAuth=fromDialog');    
      {
      url := TIdURI.Create(requestURL);
      try
        IdHTTP.CookieManager.AddServerCookie('OBBasicAuth=fromDialog', url);
      finally
        url.Free;
      end;
      }

      LHandler := TIdSSLIOHandlerSocketOpenSSL.Create(IdHTTP);
      IdHTTP.IOHandler := LHandler;

      screen.Cursor := crHourGlass;
      try
        lResponse := IdHTTP.Get(requestURL + query);
      finally
        screen.Cursor := crDefault;
      end;
    finally
      IdHTTP.Free;
    end;
  except
    on E: Exception do
      ShowMessage(E.Message);
  end;
end;