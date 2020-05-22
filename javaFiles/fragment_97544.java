@Entity
public class Book{

    private List<LocalizedString> nameList = new ArrayList<LocalizedString>();

    @OneToMany(cascade=javax.persistence.CascadeType.ALL)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    public List<LocalizedString> getNameList() {
        return this.nameList;
    }

    private List<LocalizedString> descriptionList = new ArrayList<LocalizedString>();

    @OneToMany(cascade=javax.persistence.CascadeType.ALL)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<LocalizedString> getDescriptionList() {
        return this.descriptionList;
    }



}