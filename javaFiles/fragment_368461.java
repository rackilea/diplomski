public class Map {
            private Rectangle dirtyRect = null;

            public void dirty (Rectangle areaAffected) {
                   if (null == dirtyRect) {
                        dirtyRect = areaAffected; return;
                   }
                   dirtyRect = new Rectangle ( Math.min (dirtyRect.getLeft (),
                                                         areaAffected.getLeft () ),
                                               Math.min (dirtyRect.getTop (),
                                                         areaAffected.getTop () ),
                                               Math.max (dirtyRect.getRight (),
                                                         areaAffected.getRight () ),
                                               Math.max (dirtyRect.getBottom (),
                                                         areaAffected.getBottom () ));
            }