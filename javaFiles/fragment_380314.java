if ( isCustomMarshaller(getter) ) {
    unmarshaller = new SUnmarshaller() {

        @Override
        public Object unmarshall(AttributeValue value) {
            return getCustomMarshalledValue(toReturn, getter, value);
        }
    };
}