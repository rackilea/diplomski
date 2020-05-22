xstream = new XStream(){

        @Override // we override the default behavior of this method
        protected MapperWrapper wrapMapper(MapperWrapper next) {
            return new MapperWrapper(next) {

                @Override // we override the default behavior of this method
                public boolean shouldSerializeMember(@SuppressWarnings("rawtypes") Class definedIn, String fieldName) {
                    if ( definedIn != Object.class ) {
                        return super.shouldSerializeMember(definedIn, fieldName);
                    } else {
                        return false;
                    }    
                }
            };
        }
    };