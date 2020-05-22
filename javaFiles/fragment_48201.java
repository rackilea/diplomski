Matchers.argThat(new ArgumentMatcher<Path>() {
        @Override
        public boolean matches(Object o) {
            Path p = (Path) o;
            if(p.toString().equals("some")) {
                return true;
            }else {
                return false;
            }
        }
    }