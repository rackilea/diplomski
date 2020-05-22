File file = new File("My.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(MyPojo.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MyPojo myPojo = (MyPojo) jaxbUnmarshaller.unmarshal(file);
            System.out.println(myPojo);//get your value with getter setter.