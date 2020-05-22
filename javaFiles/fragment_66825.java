boolean endLoop = false;
for (Iterator<Integer> keys = integerKey.keySet(); keys.hasNext() && !endLoop; ) {
    Integer integer = keys.next();
    if (map.containsKey(integerKey.get(integer))) {
        ...
        if (integerKey.get(integer).equals(min)) {
            endLoop = true;
        }
    } else if (integerKey.get(integer) <= min){
        ...
        endLoop = true;
    } else {
        ...
    }
}