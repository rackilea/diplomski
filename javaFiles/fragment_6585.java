public enum MyEnum implements Action {
        ACTIONABLE() {
            @Override
            public boolean isActionable() { return true; }
        },
        NOT_ACTIONABLE() {
            @Override
            public boolean isActionable() { return false; }
        };
        @Override
        public boolean isActionable() { return false;}
    }