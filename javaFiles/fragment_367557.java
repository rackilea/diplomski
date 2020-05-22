// Look at http://chunter.tistory.com/143 for information
public static AffineTransform getExifTransformation(ImageInformation info) {

    AffineTransform t = new AffineTransform();

    switch (info.orientation) {
    case 1:
        break;
    case 2: // Flip X
        t.scale(-1.0, 1.0);
        t.translate(-info.width, 0);
        break;
    case 3: // PI rotation 
        t.translate(info.width, info.height);
        t.rotate(Math.PI);
        break;
    case 4: // Flip Y
        t.scale(1.0, -1.0);
        t.translate(0, -info.height);
        break;
    case 5: // - PI/2 and Flip X
        t.rotate(-Math.PI / 2);
        t.scale(-1.0, 1.0);
        break;
    case 6: // -PI/2 and -width
        t.translate(info.height, 0);
        t.rotate(Math.PI / 2);
        break;
    case 7: // PI/2 and Flip
        t.scale(-1.0, 1.0);
        t.translate(-info.height, 0);
        t.translate(0, info.width);
        t.rotate(  3 * Math.PI / 2);
        break;
    case 8: // PI / 2
        t.translate(0, info.width);
        t.rotate(  3 * Math.PI / 2);
        break;
    }

    return t;
}