@Component
public class YourConverter implements Converter<YourIntWrapper, YourDateWrapper> {

    @Override
    public YourDateWrapper convert(YourIntWrapper source) {
                // do your stuff
        return yourOutWrapper;
    }
}