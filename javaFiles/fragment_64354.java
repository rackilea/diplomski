System.out.println(questions[intOption][0]);
        // Error handling
        try {
            do {
                strAnswer = input.readLine().toUpperCase();
            } while (!isValid(strAnswer));
        } catch (IOException e) {
            e.printStackTrace();
        }