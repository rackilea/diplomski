public static CopySoap getPort(String username, String password)  {

    Copy service = new Copy();
    CopySoap port = service.getCopySoap();

    BindingProvider bp = (BindingProvider) port;

    bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
    bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
            "https://my.site.com/sites/mysite/_vti_bin/copy.asmx");


    return port;
}   

public static void createDocument(CopySoap port) {
    String url = "https://my.site.com/sites/mysite/Shared Documents/Temp Folder/test.txt";
    String sourceUrl = "C:\\CopyFile\\READ-ME.txt";     

    DestinationUrlCollection urls = new DestinationUrlCollection();
    urls.getString().add(url);

    byte[] content = IoUtil.getBytes(new File(sourceUrl));

    FieldInformation titleInfo = new FieldInformation ();
    titleInfo.setDisplayName("Title");
    titleInfo.setType(FieldType.TEXT);
    titleInfo.setValue("Test Doc");

    FieldInformationCollection infos = new FieldInformationCollection ();
    infos.getFieldInformation().add(titleInfo);

    CopyResultCollection results = new CopyResultCollection ();

    Holder<CopyResultCollection> resultHolder = new Holder<CopyResultCollection>(results);      

    Holder<Long> longHolder = new Holder<Long>(new Long(-1));       

    port.copyIntoItems(sourceUrl, urls, infos, content, longHolder, resultHolder);

}