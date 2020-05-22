ServiceResponse response = ...
String objectType = response.getObjectType();
Class clazz = Class.forName(objectType);      // catch exception
ArrayList user = (mapper.convertValue(response.getData(), 
            TypeFactory.defaultInstance().constructCollectionType(
                    ArrayList.class, clazz)));