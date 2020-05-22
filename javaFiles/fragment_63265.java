import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("controller")
public class Controller {

    @XStreamImplicit(itemFieldName = "storageInfo")
    private List<BasicInfo> storage;

    public List<BasicInfo> getStorage() {
        return storage;
    }

    public void setStorage(final List<BasicInfo> storage) {
        this.storage = storage;
    }

}