public class ExcelFileController implements Serializable, IFileController {
    private BulkSMSContacts[] contactsSelected;
    private List<BulkSMSContacts> contacts;
    private BulkSMSContacts[] selectedcontacts;
    private BulkSMSContactsDataModel contactsList;
        public ExcelFileController() {
        contactsList = new BulkSMSContactsDataModel(contacts);
    }
    // getters and setters
    // the rest of your code