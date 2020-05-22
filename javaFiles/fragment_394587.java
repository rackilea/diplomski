BObject arrayToBArray(int[] a) {
    BClass builderClass = package.getClass("IntArrayBuilder");
    BObject builder = builderClass.getConstructor(new Class<?>[0]).newInstance(new Object[0]);
    BMethod addMethod = builderClass.getMethod("addElement", new Class<?>[]{int.class});
    for(int e : a) {
        addMethod.invoke(builder, new Object[]{ e });
    }
    BMethod makeMethod = builderClass.getMethod("addElement", new Class<?>[0]);
    BObject bArray = (BObject)makeMethod.invoke(builder, new Object[0]);
    return bArray;
}