abstract class abscractPropertyHolder {
    private String namePattern;
    private String categoryPattern;
    private String departmentPattern;
    @Autowired
    private Data data;
}

@Data
@Accessors(chain = true)
@ConfigurationProperties("main-prop.sub-prop.data")
class Data {   // if my class is public - my app run successfully, otherwise fail to 
start (exception).
    private int prop1;
    private int prop2;

    static DatanewInstanceWithDefaultParameters() {
        return new Data().setProp1(1).setProp2(0);
    }
}