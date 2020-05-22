if (compare == 0) {
    if (pObject1.hashCode() < pObject2.hashCode()) {
        compare = 1;
    } else if (pObject1.hashCode() > pObject2.hashCode()) {
        compare =  -1;
    }
}

return compare;