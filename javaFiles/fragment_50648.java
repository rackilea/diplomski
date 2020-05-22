double[] newVal = {0.0, 0.0};
    // ...
    newVal = table.get(name);   // LOOK HERE
    newVal[0] += g;
    newVal[1] += w;
    table.put(name, newVal);