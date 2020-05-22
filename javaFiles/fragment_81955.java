public class MeetingContactModel implements Serializable {

    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}


 // Fetch your selected model
 autoContact.setAdapter(new ArrayAdapter<>(requireContext(),  R.layout.spinner_item_ranking, contactList));
 autoContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             MeetingContactModel m=(MeetingContactModel) parent.getItem(position);
             String name=m.getText();
             String id=m.getId();
            }
        });