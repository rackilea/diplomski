private Gson getGson() {
    return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setExclusionStrategies(strat)
                .create();
}