@Entity
@Table(name = "mytable")
class IntegrationSchedules {
    @Id()
    @Type(type="string")
    @Column(name="rowid")
    private String rowid;
    private String officeCompanyChar
    private String officeScheduleChar
    private Integer officeCompanyNum
    private Integer officeScheduleNum
    private String default

    //getters & setters ommited
}