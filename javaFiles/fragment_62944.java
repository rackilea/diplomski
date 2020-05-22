public abstract class EE<XX extends II> {

    public static final EE<AA> A = new EE<AA>() {
        @Override
        public <PP extends AA & BB & CC> AA convert(PP instance) {
            return new AA() {
                public void a() {
                    instance.a();
                };
            };
        }
    };
    public static final EE<BB> B = new EE<BB>() {
        @Override
        public <PP extends AA & BB & CC> BB convert(PP instance) {
            return new BB() {
                public void b() {
                    instance.b();
                };
            };
        }
    };
    public static final EE<CC> C = new EE<CC>() {
        @Override
        public <PP extends AA & BB & CC> CC convert(PP instance) {
            return new CC() {
                public void c() {
                    instance.c();
                };
            };
        }
    };

    public abstract <PP extends AA & BB & CC> XX convert(PP instance);
}