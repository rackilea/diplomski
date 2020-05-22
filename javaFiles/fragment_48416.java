@XmlAccessorType( XmlAccessType.FIELD )
public class Tire
{
    double width;
    double radius;
}

@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD )
public class Axle
{
    @XmlElement( name = "tire" )
    List<Tire> tires = new ArrayList<>();
}

@XmlAccessorType( XmlAccessType.FIELD )
public class PressurizedTire extends Tire
{
    double pressure;

    public PressurizedTire( Tire t, double pressure )
    {
        this.width = t.width;
        this.radius = t.radius;
        this.pressure = pressure;
    }
}