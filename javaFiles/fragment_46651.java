try {
       field.setAccessible(true);    
       System.out.println(field.get(object));//print its fields value
     } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
                e.printStackTrace();
     }