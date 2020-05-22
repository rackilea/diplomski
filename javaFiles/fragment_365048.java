Iterator it = hm.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry myDataEntry = (Map.Entry)it.next();
        System.out.println(myDataEntry.getKey() + " = " + myDataEntry.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }