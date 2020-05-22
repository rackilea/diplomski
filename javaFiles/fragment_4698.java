String e = "Days";
String value = "Monday";

String res = Arrays.stream(Enumerations.class.getDeclaredClasses())
        .filter(c -> c.getSimpleName().equalsIgnoreCase(e))
        .findFirst()
        .map(c -> {
            String result = null;
            try {
                Object o = c.getMethod("valueOf", String.class).invoke(null, value);
                result = (String) o.getClass().getMethod("getValue").invoke(o);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e1) {
                e1.printStackTrace();
            }
            return result;
        }).orElse("Could not find");
System.out.println(res); //prints MON