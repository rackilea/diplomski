public interface CustomPersonGroup {

}

@Service
@Validated
public class SomeService {

    public void test(@Validated(value = CustomPersonGroup.class) @ValidPerson Person person) {

    }
}