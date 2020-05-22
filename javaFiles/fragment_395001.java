public class Converter extends StdConverter<Model, Wrapper> {

    @Override
    public Wrapper convert(Model model) {
        return new Wrapper(new ModelProxy(model), new Date());
    }
}