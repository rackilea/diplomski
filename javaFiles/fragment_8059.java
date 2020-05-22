public void text() {
        try {
            PrintWriter output = new PrintWriter("test.txt");
            output.println(data[0]);
            for (int i = 0; i < data.length; i++) {
                if (i != (data.length - 1)) {
                    output.printf("%d, ", data[i]);
                } else {
                    output.printf("%d", data[i]);
                }
                output.flush();
            }
        } catch (Exception ex) {

        }

    }