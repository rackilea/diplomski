@Override
public Principal getUserPrincipal() {
    return new Principal() {
        @Override
        public String getName() {
            return "Some Name";
        }
    };
}