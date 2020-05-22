@TypeConverter
    public static Category fromStringToCategory(String category) {
        if (TextUtil.isEmpty(category))
            return DEFAULT_CATEGORY;
        return YOUR_LOGIC_FOR_CONVERSION;
    }