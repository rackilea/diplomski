@Component
public class MyResources {

    @Value("${my.value}") // value always is null!!!
    private String PATH_TO_FONTS_FOLDER;
}