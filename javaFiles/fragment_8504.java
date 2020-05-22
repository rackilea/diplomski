public String toString() {
    StringBuilder sb = new StringBuilder();
    Class<?> thisClass = this.getClass();
    Field[] aClassFields = thisClass.getDeclaredFields();
    for (Field f : aClassFields) {

        //skip static and synthetic fields:
        if (f.isSynthetic() || Modifier.isStatic(f.getModifiers())) continue;
        // get value only once: 
        Object value = f.get(this);

        String fName = f.getName();
        fName = fName.startsWith("_") ? fName.substring(1) : fName;
        if (value != null) { // and use this value here
            if (value instanceOf String[]) {
                StringBuilder stringArrayStr = new StringBuilder();
                for (String s : (String[]) value) { // and here
                    stringArrayStr.append(fName).append(": ").append(s).append(", ");
                }
                sb.append(stringArrayStr);
            } else {
                sb.append(getVariableNameStr(fName, value.toString()));
            }
        }
    }
    return sb.toString().substring(0, sb.toString().length() - 2);
}