public <T extends Z> List<T> getGenericList(Class<T> klass) {
        List<T> list = new ArrayList<T>();
        try {
            list.add(klass.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }