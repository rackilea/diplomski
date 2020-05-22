import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class Parent<T> {
    protected List<T> list;

    public abstract List<T> getList();
    public abstract void setList(List<T> list);

}