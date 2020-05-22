binder.registerCustomEditor(EnumSet.class, "enumSet",
    new PropertyEditorSupport() {
        @Override
        public void setValue(Object value) {
            EnumSet<EnumInnerObject> set = EnumSet.noneOf(EnumInnerObject.class);

            for (String val: (String[]) value) {
                set.add(EnumInnerObject.valueOf(val));
            }

            super.setValue(set);
        }
    });