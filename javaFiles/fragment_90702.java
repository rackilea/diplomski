@Component
@RequiredArgsConstructor
public class RetrofitFactoryBean extends AbstractFactoryBean<Object> {

    @Getter
    private final Class<?> objectType;
    private final retrofit2.Retrofit retrofit;

    @Override
    protected Object createInstance() throws Exception {
        return retrofit.create(objectType);
    }
}