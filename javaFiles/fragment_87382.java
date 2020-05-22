public Object select(MyObj source) {
        MyObj myobj = new MyObj ();
        if (!restrictedFields.isEmpty()) {
            // Instead of refelction here I can use the biconsumer in the enum

            for (RestrictFields field : restrictedFields) {
                field.copy(source, myobj);
            }
            return myObj;
        }
        return source;

    }