public Function a(Object m) {

    if (m instanceof BasicDbObject) return doDbObject(m);
    if (m instanceof OtherDbObject) return doOtherDbObject(m);

    return doGenericObject(m);
}