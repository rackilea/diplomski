Field hm= SourceViewer.class.getDeclaredField("fVerticalRulerHoveringController");
    hm.setAccessible(true);
    AnnotationBarHoverManager ma= (AnnotationBarHoverManager) hm.get(sourceViewer);
    Field ah= AnnotationBarHoverManager.class.getDeclaredField("fAnnotationHover");
    ah.setAccessible(true);
    ah.set(ma, MyAwesomeHover());