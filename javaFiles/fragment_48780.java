public Map<Object,String> getStudentPictureIds() {
    return new QuickMap<Object,String>() {
        @Override
        public String get(Object k) {
            PictureTypeEnum type;
            if (k instanceof PictureTypeEnum) {
                type = (PictureTypeEnum)k; 
            } else {
                type = PictureTypeEnum.valueOf(k.toString());
            }
            return getStudentPictureId(type);
        }            
    };
}