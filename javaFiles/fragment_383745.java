public int compare(Pizza o1, Pizza o2) {

    int compvalue = o1.getPizzType().compareTo(o2.getPizzType());
    if(compvalue == 0)
    {
        compvalue = o1.getCheeseType().compareTo(o2.getCheeseType());
        ...etc..
        if(compvalue == 0)
        ...
    }
    return compvalue;
}