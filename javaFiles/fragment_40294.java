public void generateEmailData(int numOfMessage, Class<T> emailClass) {       
        for (int i = 0; i < numOfMessage; i++) {
            String message = emailClass.newInstance().generateRandomMessage();
            System.out.println(message);
        }
    }