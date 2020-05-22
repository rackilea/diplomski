Bson filter;
if (optionFieldRequired) {
  Bson filter = and(eq("field1", value),
                    gt("field2", value2));
} else {
  Bson filter = and(eq("field1", value),
                    gt("field2", value2),
                    eq("field3", optionalValue));
}