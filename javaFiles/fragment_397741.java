@Entity
@ForeignKey(name = "id")
@Table(name = "code_table")
public class CodeTable extends  ObjectClass{
    private String description;

    public CodeTable() { }

    public String getDescription() { return description; }
    public void setDescription(String description) { 
        this.description = description; 
    }
    @Override
    public String toString() {
    return "CodeTable [getDescription()=" + getDescription() + ", getId()="
            + getId() + "]";
    }
}