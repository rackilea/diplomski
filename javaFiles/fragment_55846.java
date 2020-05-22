@Getter @Setter
private String name;

@Getter @Setter
private TreeMap<String, String> companyExperience;

public Person(){
    companyExperience = new TreeMap<String, String>();
}