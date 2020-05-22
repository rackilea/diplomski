if (isCustomMarshaller(getter)) {
                if (isCollection) {
                    unmarshaller = new SSUnmarshaller() {

                        @Override
                        public Object unmarshall(AttributeValue value) {
                            return getCustomMarshalledValueSet(toReturn, getter, value);
                        }
                    };
                } else {
                    unmarshaller = new SUnmarshaller() {

                        @Override
                        public Object unmarshall(AttributeValue value) {
                            return getCustomMarshalledValue(toReturn, getter, value);
                        }
                    };
                }

            }