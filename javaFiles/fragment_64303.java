double dx = Math.abs(rectX - squareX);
double dy = Math.abs(rectY - squarey);
double dw2 = (rectW + squareW) / 2;
double dh2 = (rectL + squareW) / 2;

if (Double.compare(dx, dw2) == 0 && Double.compare(dy, dh2) == 0)
    return CORNER_TOUCH;
else if (Double.compare(dx, dw2) > 0 || Double.compare(dy, dh2) > 0)
    return OUTSIDE;
else if (Double.compare(dx, dw2) == 0 || Double.compare(dy, dh2) == 0)
    return EDGE_TOUCH;
else if (Double.compare(dx, rectW - dw2) <= 0 &&
        Double.compare(dy, rectL - dh2) <= 0)
    return INSIDE;
else 
    return OVERLAPS;