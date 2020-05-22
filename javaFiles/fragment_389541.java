UIComponent headFacet = context.getViewRoot().getFacet("javax_faces_location_HEAD");
if (headFacet == null) {
    System.out.println("No Head Facet");
} else {
    System.out.println("Head Children: " + headFacet.getChildCount());
    for (UIComponent c : headFacet.getChildren()) {
        System.out.println(c.getRendererType());
        System.out.println(c.getAttributes().get("name"));
    }
}