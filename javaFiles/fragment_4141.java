public void ShippEbayOrder(EbayOrder ebayOrder)
    {
        string Developer = WebConfigurationManager.AppSettings["EbayProductionDevID"];
        string Application = WebConfigurationManager.AppSettings["EbayProductionAppID"];
        string Certificate = WebConfigurationManager.AppSettings["EbayProductionCertID"];
        string eBayToken = WebConfigurationManager.AppSettings["EbayProductionUserToken"];
        string SoapApiServerUrl = WebConfigurationManager.AppSettings["EbayProductionApiServerUrl"];
        string SignInUrl = WebConfigurationManager.AppSettings["EbayProductionSignInUrl"];
        string EPSServerUrl = WebConfigurationManager.AppSettings["EbayProductionEPSUrl"];

        var ebayService = new eBayAPIInterfaceService();

        string version = "551";
        string requestUrl = SoapApiServerUrl + "?callname=CompleteSale&siteid=0"
                            + "&appid=" + Application + "&version=" + version + "&routing=default";
        ebayService.Url = requestUrl;
        ebayService.RequesterCredentials = new CustomSecurityHeaderType();
        ebayService.RequesterCredentials.Credentials = new UserIdPasswordType();
        ebayService.RequesterCredentials.Credentials.AppId = Application;
        ebayService.RequesterCredentials.Credentials.DevId = Developer;
        ebayService.RequesterCredentials.Credentials.AuthCert = Certificate;
        ebayService.RequesterCredentials.eBayAuthToken = eBayToken;

        CompleteSaleRequestType completeSaleRequestType = new CompleteSaleRequestType();
        completeSaleRequestType.Version = version;

        if (ebayOrder.ContainsOrderType == EbayOrder.OrderType.Transaction)
        {
            completeSaleRequestType.TransactionID = ebayOrder.SourceOrderId;
            completeSaleRequestType.ItemID = ebayOrder.ItemsInfo[0].SourceItemId;
        }
        else
            completeSaleRequestType.OrderID = ebayOrder.SourceOrderId;

        completeSaleRequestType.Shipped = true;
        completeSaleRequestType.ShippedSpecified = true;
        CompleteSaleResponseType completeSaleResponseType = ebayService.CompleteSale(completeSaleRequestType);
    }