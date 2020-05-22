public enum MapFunction implements SerializableBiFunction<MapView, Object, Object> {
    CONTAINS_VALUE {
        @Override
        public Boolean apply(@NotNull MapView map, Object value) {
            Class vClass = map.valueType();
            return map.containsValue(convertTo(vClass, value));
        }
    },
    REMOVE {
        @Override
        public Object apply(@NotNull MapView map, Object o) {
            Class kClass = map.keyType();
            Class vClass = map.valueType();
            KeyValuePair kf = (KeyValuePair) o;
            return map.remove(convertTo(kClass, kf.key), convertTo(vClass, kf.value));
        }
    },
    REPLACE {
        @Override
        public Object apply(@NotNull MapView map, Object o) {
            Class kClass = map.keyType();
            Class vClass = map.valueType();
            if (o instanceof KeyValuePair) {
                KeyValuePair kf = (KeyValuePair) o;
                return map.replace(convertTo(kClass, kf.key), convertTo(vClass, kf.value));
            }
            KeyValuesTuple kf = (KeyValuesTuple) o;
            return map.replace(convertTo(kClass, kf.key), convertTo(vClass, kf.oldValue), convertTo(vClass, kf.value));
        }
    },