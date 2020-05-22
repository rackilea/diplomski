public class Parameter {

    public static void main(String... args) throws Exception {

        PxViewFull<OutputDTO> output40813 = PxViewFull.create(OutputDTO.class, ServiceOutputView.class);
    }

}

class ServiceCall<X> {

}

class OutputDTO extends ServiceCall<OutputDTO> {

    public OutputDTO serviceCall() {

        // i guess i pupulate myself?
        return this;
    }
}

class PxViewFull<X> {

    private X dtoObject;
    private Class<X> dtoObjectType;

    public static <P1, P2 extends PxViewFull<?>, RESULT extends PxViewFull<P1>> RESULT create(
            Class<P1> dtoClass,
            Class<P2> viewClass) throws Exception {

        return null;
    }

    public void setDtoObjectType(final Class<X> dtoObjectType) {

        this.dtoObjectType = dtoObjectType;
    }

    public void setModel(Object o) {

        if (!dtoObjectType.isInstance(o))
            throw new IllegalArgumentException();

        this.dtoObject = dtoObjectType.cast(o);
    }

}

class ServiceOutputView<T extends ServiceCall<?>> extends PxViewFull<T> {

}