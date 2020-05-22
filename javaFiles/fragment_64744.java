import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Simple", propOrder = {
    "content"})
public class Simple extends Valor{

    @XmlElements({
        @XmlElement(name="content",type=String.class),
        @XmlElement(name="content",type=Integer.class),
    })
    protected Object content;

    public Object getContent() {
        return content;
    }

    @Override
    public String getValorString() {
        throw new UnsupportedOperationException();
    }

    public void setContent(Object content) {
        this.content = content;
    }

}