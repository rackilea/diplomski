switch(items[place]) {
    case 0:
        return false;
    case 1:
        items[place] = 0;
        return true;
    case 2:
        items[place] = 1;
        return true;
    default:
        return false;
}