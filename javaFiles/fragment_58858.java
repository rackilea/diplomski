import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlSeeAlso({Ferrari.class})
@XmlType
public abstract class Car {
  public abstract void drive(double miles);
}