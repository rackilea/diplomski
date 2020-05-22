public class Contacts {
    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = new ArrayList<Contact>();

    /**
     *
     * @return
     * The contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     *
     * @param contacts
     * The contacts
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}