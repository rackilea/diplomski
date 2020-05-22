public class MemberTableModel extends AbstractTableModel {

    private String[] headers = {"Last Name", "First Name", "SS#", "Email", "Phone Number", "Address"};
    private List<Member> members;

    public MemberTableModel() {
        members = new ArrayList<>(25);
    }

    public MemberTableModel(List<Member> members) {
        this();
        this.members.addAll(members);
    }

    public MemberTableModel(Member... members) {
        this(Arrays.asList(members));
    }

    @Override
    public int getRowCount() {
        return members.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }