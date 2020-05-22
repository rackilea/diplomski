int weightBasedEqual(Person a, Person b)

        // For each field annotated with @Weight
        for(Field field : a.getClass().getDeclaredFields()){

            if(field.isAnnotationPresent(Weight.class)){

                // Get the weight
                int weight = field.getAnnotation(Weight.class).value();

                Object valueFromA = field.get(a); // Get field value for A 
                Object valueFromB = field.get(b); // Get field value for B
                // Compare the field value from 'a' and 'b' here and do with the weight whatever you like   
            }
       }
        return result;
    }
}