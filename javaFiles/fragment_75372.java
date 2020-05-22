ObjectInputStream objectInput = new ObjectInputStream(sock.getInputStream());

        Object objectFromClient = objectInput.readObject();

        if (objectFromClient instanceof MyClass1) {

        } else if (objectFromClient instanceof MyClass2) {

        }// etc..