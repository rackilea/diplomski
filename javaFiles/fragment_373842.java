public class BulkSMSContactsDataModel extends ListDataModel<BulkSMSContacts> implements SelectableDataModel<BulkSMSContacts> {    

public BulkSMSContactsDataModel() {  
}  

public BulkSMSContactsDataModel(List<BulkSMSContacts> data) {  
    super(data);  
}  

@Override  
public BulkSMSContacts getRowData(String rowKey) {         
   List<BulkSMSContacts> contacts = (List<BulkSMSContacts>) new yourDao.getListOfBulkSMSContacts(); //yourDAO :BulkSMSContactsSelector i guess
    for(BulkSMSContacts c : contacts) {  
        if(String.valueOf(c.getContactId()).equals(rowKey))  
            return c;  
    }  

    return null;  
}  

@Override  
public Object getRowKey(BulkSMSContacts obj) {  
    return String.valueOf(obj.getContactId());  
}