public class Model extends AbstractModel<Model>{


    private Model(final Builder builder) {
        super(builder);
    }

    public static class Builder2 extends AbstractModel.Builder<Model> {

        @Override
        public Model Build() {
            return new Model(this);
        }
    }
}