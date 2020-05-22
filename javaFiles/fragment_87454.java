public static class DisablingJsonIgnoreIntrospector extends JacksonAnnotationIntrospector {

    @Override
    public boolean hasIgnoreMarker(final AnnotatedMember m) {
        return false;
    }

}