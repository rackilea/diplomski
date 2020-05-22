@Service("mySpecialBean")
public class MyBean implements BeanBase {

}

public class App {
    @Autowired
    @Qualifier("mySpecialBean")
    private BeanBase beanBase;
}