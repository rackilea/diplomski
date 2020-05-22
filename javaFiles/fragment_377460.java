Object value = null;
try {
    value = field.get(abc);
} catch (IllegalAccessException e) {
    e.printStackTrace();
}