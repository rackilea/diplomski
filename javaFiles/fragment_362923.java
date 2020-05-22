Unmarshaller unmarshaller = jc.createUnmarshaller();
    unmarshaller.setEventHandler(new ValidationEventHandler() {

        @Override
        public boolean handleEvent(ValidationEvent event) {
            System.out.println(event);
            return true;
        }
    });