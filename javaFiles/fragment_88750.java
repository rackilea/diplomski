public void setAppIcons(JFrame frame) {
    List<Image> images = new ArrayList<Image>();
    images.add(getImage(MessageUtils.getString("application.images.icon.app.32")).getImage());
    images.add(getImage(MessageUtils.getString("application.images.icon.app.16")).getImage());

    try {
        Class<?> [] types = {java.util.List.class};
        Method method = Class.forName("java.awt.Window").getDeclaredMethod("setIconImages", types);

        Object [] parameters = {images};
        method.invoke(frame, parameters);
    } catch (Exception e) {
        frame.setIconImage(images.get(0));
    }       
}