ExchangeService service = new ExchangeService();
//login to your exchange server with credentials etc & set your service url
.....

//issue your search for a given user using EmailMesssageSchema.From  
FindItemsResults <Item> results = service.findItems(WellKnownFolderName.Inbox, 
new SearchFilter.IsEqualTo(EmailMessageSchema.From, "SomeUser"), new ItemView(100));