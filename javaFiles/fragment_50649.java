for (int j = 0;j<attrIndex.length;j ++){
    String name = train.attribute(attrIndex [j]).name();
    double g = eval.evaluateAttribute(attrIndex[j]);
    double w = 1;
    if (g == 0.0) 
        w = 0.5;
    double[] val = table.get(name);
    val[0] += g;
    val[1] += w;
}