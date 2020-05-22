for (Field field : Color.class.getDeclaredFields()) {
        int modifiers = field.getModifiers();
        if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)
                && Modifier.isFinal(modifiers) && field.getType() == Color.class) {
            String colorName = field.getName().toLowerCase(Locale.US);
            Color color = Color.valueOf(colorName);
            System.out.printf("- %s -> %s%n", colorName, color);
        }
    }