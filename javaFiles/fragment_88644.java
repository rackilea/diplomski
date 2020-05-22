@Document(collection="employee-territories")
public class EmployeeTerritory {

    @Id
    private ObjectId id;
    @Field("EmployeeID")
    private Integer employeeID;
    @Field("TerritoryID")
    private Integer territoryID;

    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public Integer getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }
    public Integer getTerritoryID() {
        return territoryID;
    }
    public void setTerritoryID(Integer territoryID) {
        this.territoryID = territoryID;
    }
}