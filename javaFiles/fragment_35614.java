public double totals(){
    double itotal = 0.0;    //#A
    for (Iterator<Items> it = items.iterator(); it.hasNext();) {   //#B
       Items i = it.next();   //#C
       itotal += i.getTotal(); //#D
    }
    return itotal; //#E
}