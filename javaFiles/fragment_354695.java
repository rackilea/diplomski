import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FluentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String someName;
    private int someNumber;
    private boolean someFlag;

    protected FluentEntity(){}

    private FluentEntity(String someName, int someNumber, boolean someFlag) {
        this.someName = someName;
        this.someNumber = someNumber;
        this.someFlag = someFlag;
    }

    public long getId() {
        return id;
    }

    public String getSomeName() {
        return someName;
    }

    public int getSomeNumber() {
        return someNumber;
    }

    public boolean isSomeFlag() {
        return someFlag;
    }

    public static FluentEntityBuilder builder() {
        return new FluentEntityBuilder();
    }

    public static class FluentEntityBuilder {

        private String someName;
        private int someNumber;
        private boolean someFlag;

        public FluentEntityBuilder setSomeName(final String someName) {
            this.someName = someName;
            return this;
        }

        public FluentEntityBuilder setSomeNumber(final int someNumber) {
            this.someNumber = someNumber;
            return this;
        }

        public FluentEntityBuilder setSomeFlag(final boolean someFlag) {
            this.someFlag = someFlag;
            return this;
        }

        public FluentEntity build() {
            return new FluentEntity(someName, someNumber, someFlag);
        }

    }

}