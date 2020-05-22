private static Object sum(Iterable self, Object initialValue, boolean first) {
        Object result = initialValue;
        Object[] param = new Object[1];
        for (Object next : self) {
            param[0] = next;
            if (first) {
                result = param[0];
                first = false;
                continue;
            }
            MetaClass metaClass = InvokerHelper.getMetaClass(result);
            result = metaClass.invokeMethod(result, "plus", param);
        }
        return result;
}