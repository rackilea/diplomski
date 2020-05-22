import javax.xml.bind.annotation.adapters.*;

@XmlJavaTypeAdapter(TitleAdapter.class)
public enum Title { 
   MRS,
   MR,
   NONE;
}