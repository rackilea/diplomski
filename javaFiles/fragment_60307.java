// Affine Transformation 3, 4 and 5
    //                   ╭ umax − umin   vmax − vmin ╮
    // T(umin, vmin) ◦ S | ----------- , ----------- | ◦ T(-xmin, -ymin)
    //                   ╰ xmax − xmin   ymax − ymin ╯
    AffineTransform at = new AffineTransform();
    at.translate(umin, vmin);
    at.scale((umax-umin)/(xmax-xmin), (vmax-vmin)/(ymax-ymin));
    at.translate(-xmin, -ymin);