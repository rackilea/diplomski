@Entity
class User {
    @Id
    @Generated Value
    long id;

    // All the reports where this user is contributor
    @OneToMany(mappedBy="contributor")
    List<Report> contributorReports; 

    // All the reports where this user is owner
    @OneToMany(mappedBy="owner")
    List<Report> ownerReports; 

    String username;
}