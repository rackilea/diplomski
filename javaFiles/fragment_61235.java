public class Test {
    public static void main(String[] args) {
        TopClass top = …; // initialise as appropriate
        System.out.println(findFields(top, SuperClass.class));
    }

    private static <T> List<T> findFields(Object haystack, Class<T> needle) {
        return findFields0(haystack, needle, new HashSet<Object>(), new ArrayList<T>());
    }

    private static <T> List<T> findFields0(Object haystack, Class<T> needle, Set<Object> visited, List<T> result) {
        if (visited.contains(haystack)) return result; // we already searched this object

        visited.add(haystack);

        for (Field field : haystack.getClass().getFields()) {
            field.setAccessible(true);
            Object fieldValue = null;
            try {
                fieldValue = field.get(haystack);
            } catch (IllegalAccessException e) {
                // shouldn't happen
                throw new RuntimeException(e);
            }
            if (needle.isAssignableFrom(field.getType())) {
                result.add(needle.cast(fieldValue));
            }

            // recurse
            findFields0(fieldValue, needle, visited, result);
        }
        return result;
    }
}