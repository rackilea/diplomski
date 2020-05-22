public static <T, U extends T> Class<? extends U> asSubClaz(Class<T> t, Class<U> c){
        return t.asSubClass(c);
    }
    public static <T, U> Class<? extends U> asSubClazOriginal(Class<T> t, Class<U> c){
        return t.asSubClass(c);
    }
    asSubClazOriginal(List.class, String.class);
    asSubClaz(List.class, String.class); //error. So would have broken legacy code