@Entity
@Table(name = "Word")
@Inheritance(strategy=InheritanceType.JOINED)  
public abstract class Word implements Serializable{

    // primary key and other columns

    @Embedded
    protected Stems stems = new Stems();

    public List<Stem> getStems() {
        return stems.getStems();
    }

    public void setStems(List<Stem> stems) {
        this.stems.setStems(stems);
    }
}