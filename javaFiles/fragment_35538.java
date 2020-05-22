final class JsonElementSplitters {

    private JsonElementSplitters() {
    }

    static <V> Splitter<Map.Entry<String, V>, JsonObject, String, V> of(final Function<? super String, ? extends String[]> keyToKeyGroup) {
        return of(keyToKeyGroup, JsonElementSplitters::simpleObjectToSimpleJsonElement);
    }

    static <V> Splitter<Map.Entry<String, V>, JsonObject, String, V> of(final Function<? super String, ? extends String[]> keyToKeyGroup,
            final Gson gson) {
        return of(keyToKeyGroup, gson::toJsonTree);
    }

    static <V> Splitter<Map.Entry<String, V>, JsonObject, String, V> of(final Function<? super String, ? extends String[]> keyToKeyGroup,
            final Function<? super V, ? extends JsonElement> valueToJsonElement) {
        return Splitter.of(
                Map.Entry::getKey,
                Map.Entry::getValue, keyToKeyGroup,
                JsonObject::new,
                (innerJsonObject, key) -> {
                    final JsonElement jsonElement = innerJsonObject.get(key);
                    return jsonElement != null ? jsonElement.getAsJsonObject() : null;
                },
                (jsonObject, property, value) -> jsonObject.add(property, valueToJsonElement.apply(value))
        );
    }

    // In simple cases we can do a primitive box value to a simple JSON value   
    private static JsonElement simpleObjectToSimpleJsonElement(final Object o) {
        if ( o == null ) {
            return JsonNull.INSTANCE;
        }
        if ( o instanceof JsonElement ) {
            return (JsonElement) o;
        }
        if ( o instanceof Boolean ) {
            return new JsonPrimitive((Boolean) o);
        }
        if ( o instanceof Number ) {
            return new JsonPrimitive((Number) o);
        }
        if ( o instanceof String ) {
            return new JsonPrimitive((String) o);
        }
        if ( o instanceof Character ) {
            return new JsonPrimitive((Character) o);
        }
        throw new IllegalArgumentException("Cannot convert " + o.getClass());
    }

}