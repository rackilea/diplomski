@Override
protected void onBeforeRender() {
    //
    // ... init resource ...
    //

    Image image = new Image("img", resource);
    addOrReplace(image);
    System.out.println(getRequestCycle().urlFor(image, IResourceListener.INTERFACE));

    super.onBeforeRender();
}