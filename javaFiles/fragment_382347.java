for(int i = 0; i < arrayList.size(); i++) {
    Class<?> cls = Class.forName(arrayList.get(i)); //Get class for the name

    Object instance = cls.newInstance();
    ...
}