public class StackFile {
private String ID;
private String Name;
private String Date;
public String getID() {
    return ID;
}
public void setID(String iD) {
    ID = iD;
}
public String getName() {
    return Name;
}
public void setName(String name) {
    Name = name;
}
public String getDate() {
    return Date;
}
public void setDate(String date) {
    Date = date;
}
public StackFile(String  _ID,String _name,String _date)
{
    ID=_ID;
    Name=_name;
    Date=_date;