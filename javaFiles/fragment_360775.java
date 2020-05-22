package domain.app.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class History {
    @Column(name="HISTORY")
    private String someAttribute;

    public String getSomeAttribute() {
        return someAttribute;
    }

    public void setSomeAttribute(String someAttribute) {
        this.someAttribute = someAttribute;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((someAttribute == null) ? 0 : someAttribute.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        History other = (History) obj;
        if (someAttribute == null) {
            if (other.someAttribute != null)
                return false;
        } else if (!someAttribute.equals(other.someAttribute))
            return false;
        return true;
    }

}