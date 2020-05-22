// **SERIALIZATION PART** (nothing special, simple Gson serialization)
// Creating a list to pass as parameter to the container class
List<BaseClass> derivedClasses = new ArrayList<>();
derivedClasses.add(new DerivedClassA());
derivedClasses.add(new DerivedClassB());
// Creating the container class to be serialized
ToSerializeClass serializeClass = new ToSerializeClass(derivedClasses);

Gson gson = new Gson();

String json = gson.toJson(serializeClass);
// json = {"TestString":"TestStringValue","DerivedClasses":[{"FieldA":"This is a derived class.","Method":"ClassA"},{"FieldB":"This is ANOTHER derived class.","IntValue":10,"Method":"ClassB"}]}


// **DESERIALIZATION PART** (with custom deserializer)
// creating the custom deserializer, which will find the derived class' type as the class' "Method" field value. With that value, it can resolve the type.. see below
ClassDeserializerAdapter deserializer = new ClassDeserializerAdapter("Method");
// registering each Type into the Deserializer's HashMap (key-value pair), where the key (String) must be carried by the object (you can find it in the BaseClass, called "Method")
deserializer.registerClassType("ClassA", DerivedClassA.class);
deserializer.registerClassType("ClassB", DerivedClassB.class);
Gson gsonB = new GsonBuilder().registerTypeAdapter(BaseClass.class, deserializer).create();

// deserializing
ToSerializeClass deserialized = gsonB.fromJson(json, ToSerializeClass.class); // CORRECT!