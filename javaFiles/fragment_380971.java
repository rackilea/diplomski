@Component
public class MyTaskFactoryImpl implements MyTaskFactory {
    @Autowired
    Field myField;

    @Override
    public MyTask newTask() {
        return new MyTask(myField);
    }
}