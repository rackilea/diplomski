private static Float toFloat(Float def, String str) {
    try {
        return str != null ? Float.parseFloat(str) : def.floatValue();
        // Note ----------------------------------------^^^^^^^^^^^^^
    } catch (NumberFormatException e) {
        return def;
    }
}