while (!received.equals("QUIT")) {
            if (head.equals("rep:"))
                changeText(tail);

            else if (head.equals("app:"))
                appendText(tail);

            output.println(text);
            output.println("ECHO: " + received);
        }