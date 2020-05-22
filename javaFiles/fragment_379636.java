import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;


@Entity

public class Category implements Serializable {

@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
private Long id;
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="NAME_ID")
private Localised nameStrings = new Localised();

@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="DESCRIPTION_ID")
private Localised descriptionStrings = new Localised();

private static final long serialVersionUID = 1L;

public Category() {

    super();
}  

public Category(String locale, String name, String description){
    this.nameStrings.addString(locale, name);
    this.descriptionStrings.addString(locale, description);
}
public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}   

public String getName(String locale) {
    return this.nameStrings.getString(locale);
}

public void setName(String locale, String name) {
    this.nameStrings.addString(locale, name);
}
public String getDescription(String locale) {
    return this.descriptionStrings.getString(locale);
}

public void setDescription(String locale, String description) {
    this.descriptionStrings.addString(locale, description);
}

}




import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Localised {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int dummy = 0;
    @ElementCollection
    private Map<String,String> strings = new HashMap<String, String>();

    //private String locale;    
    //private String text;

    public Localised() {}

    public Localised(Map<String, String> map) {
        this.strings = map;
    }

    public void addString(String locale, String text) {
        strings.put(locale, text);
    }

    public String getString(String locale) {
        String returnValue = strings.get(locale);
        return (returnValue != null ? returnValue : null);
    }

}