if ((index < generation.length)) {
//Graphics code
y += (height of pageIndex) + 10;
    if(y > yMax){
        y = 0;
        pageIndex = 0;
        page++;
        return PAGE_EXISTS; 
    } else {
        pageIndex++;
        return PAGE_NOT_FULL; 
    }
} else {
    return NO_SUCH_PAGE;
}