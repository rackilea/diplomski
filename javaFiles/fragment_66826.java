for (Integer integer: integerKey.keySet()) {
    boolean endLoop = false;
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
    if (endloop)
        break;
}