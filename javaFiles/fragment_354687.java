@ManagedBean(name="Demo")  //Annotation.You can also define this entry in faces-config.xml
@RequestScoped    //Scope of the bean

public class TestDemo
{
private Date dtDateOfBirth;


public Date getDtDateOfBirth() {
        return dtDateOfBirth;
    }

    public void setDtDateOfBirth(Date dtDateOfBirth) {
        this.dtDateOfBirth = dtDateOfBirth;
    }
}