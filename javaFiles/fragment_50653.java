@Module
public class NumberModule {
    @Inject
    public NumberModule() {}

    @Provides
    Logger provideLogger(@Named("logger_tag") String tag){
        Logger logger = new Logger(tag);
        return logger;
    }

    @Provides
    InvertNumber provideTempManager(Logger logger){
        return new InvertNumber(logger);
    }
}

@Component(modules = NumberModule.class)
public interface NumberComponent {

    InvertNumber getInvertNumber();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder loggerTag(@Named("logger_tag") String tag);

        NumberComponent build();
    }
}