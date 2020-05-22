public interface GlobalResources extends ClientBundle {
        public static final GlobalResources RESOURCE =  GWT.create(GlobalResources.class);

        @Source("GlobalStyles.css")
        GlobalStylesheet styles();

    }