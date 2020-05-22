import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Stereotypes {

    private List<AbstractStereotype> sterotypes;

    @XmlElementRef
    public List<AbstractStereotype> getSterotypes() {
        return sterotypes;
    }

    public void setSterotypes(List<AbstractStereotype> sterotypes) {
        this.sterotypes = sterotypes;
    }

}