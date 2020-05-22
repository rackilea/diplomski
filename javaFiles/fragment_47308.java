@Entity 
@Table(name = "persons")
@Audited 
@AuditTable(name = "audit_persons")
//secondary table referencing our new view
@SecondaryTable(name = "vw_person_additional_data", 
                   pkJoinColumns = {@PrimaryKeyJoinColumn(name = "person_id", 
                        referencedColumnName = "id")}) 
public class Person {
        private String id;
        private String name;
        private Job job;

        @Column(name = "username", table="vw_person_additional_data") //column in view
        private String createdBy;
}