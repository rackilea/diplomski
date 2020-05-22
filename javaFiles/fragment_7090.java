// Make sure we stay in-bounds
    if(newX + i.left <= -__x)
        newX = -__x - i.left + 1;
    if(newY + i.top <= -__y)
        newY = -__y - i.top + 1;
    if(newX + __x + i.right >= pWidth)
        newX = pWidth - __x - i.right - 1;
    if(newY + __y + i.bottom >= pHeight)
        newY =  pHeight - __y - i.bottom - 1;