.allMatch(f -> {
        f.setAccessible(true);
        try {
            return (f.getType() == boolean.class && f.getBoolean(o) == false)
                    || (f.getType().isPrimitive() && f.getDouble(o) == 0)
                    || f.get(o) == null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    });