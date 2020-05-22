@Entity
@Inheritance //by default SINGLE_TABLE strategy
@DiscriminatorColumn( //not supported for TABLE_PER_CLASS strategy
    name = "BUS_TYPE", 
    discriminatorType = DiscriminatorType.INTEGER
)
public abstract class Bus {
    @Id
    protected int id;
    protected int seats;

    public Bus() {
    }
}

@Entity
@DiscriminatorValue(value = "1") //not supported for TABLE_PER_CLASS strategy
public class BusSubClass1 extends Bus {
    private String specific1;

    public BusSubClass1() {
    }
}

@Entity
@DiscriminatorValue(value = "2") //not supported for TABLE_PER_CLASS strategy
public class BusSubClass2 extends Bus {
    @Temporal
    private Data specific2;

    public BusSubClass2() {
    }
}