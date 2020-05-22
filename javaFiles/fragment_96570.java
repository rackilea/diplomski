@Service
public class SomeOtherClass {
    private SecondaryClass secondary;

    @Autowired
    public void setSecondary(SecondaryClass secondary) {
        this.secondary = secondary;
    }

    public String accessSimpleJdbcDaoImpl() {
        return "We're at Some Other Class: " + secondary.printSecCount();
    }
}

@Service
public class SecondaryClass {

    private SimpleJdbcDaoImpl simpleJdbcDaoImpl;

    @Autowired
    public void setSimpleJdbcDaoImpl(SimpleJdbcDaoImpl impl) {
        simpleJdbcDaoImpl = impl;
    }

    public String printSecCount() {
       return "Secondary class Circle count is: " + simpleJdbcDaoImpl.getCircleCount();
    }
}