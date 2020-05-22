import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TitleAdapter extends XmlAdapter<TitleAdapter.AdaptedTitle, Title>{

    @XmlType(name="title")
    public enum AdaptedTitle {
        @XmlEnumValue("mrs") MRS,
        @XmlEnumValue("mrs") MR
    }

    @Override
    public Title unmarshal(AdaptedTitle v) throws Exception {
        switch(v) {
        case MRS:
            return Title.MRS;
        case MR:
            return Title.MR;
        }
        return null;
    }

    @Override
    public AdaptedTitle marshal(Title v) throws Exception {
        switch(v) {
        case MRS:
            return AdaptedTitle.MRS;
        case MR:
            return AdaptedTitle.MR;
        }
        return null;
    }

}