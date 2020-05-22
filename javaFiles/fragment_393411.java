url := TIdURI.Create('https://api.auspost.com.au/DeliveryDates.xml');
try
  IdHTTP.CookieManager.AddServerCookie('OBBasicAuth=fromDialog', url);
finally
  url.Free;
end;