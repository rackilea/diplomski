import java.util.List;
import javafx.scene.image.Image;
import javax.xml.bind.annotation.XmlRootElement;
import jumpNRun.gameObjects.entitys.Solid;


@XmlRootElement
public class Entity {

    protected Image entityImage;

    protected double gravity = 0;

    protected int height = 0, width = 0;

    protected int x = 0, y = 0;

    protected int id = 0;
    /**
     * Class speciefed informations
     */
    protected String extraInfo;
    protected boolean killed = false;

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }