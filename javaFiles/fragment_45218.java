@Entity(name="MYENTITY")
public class MyEntity {
    void Accept(EntityVisitor visitor)
    {
        visitor.visit(this);
    }
}