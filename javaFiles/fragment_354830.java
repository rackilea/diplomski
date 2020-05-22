Annotation annotation = Test.class.getAnnotation(Info.class);

        if(annotation instanceof Info){
            Info info = (Info) annotation;

            assertEquals("ABC", info.name());
            assertEquals("1.1.1", info.version());
        } else {
            fail("Did not find annotation");
        }