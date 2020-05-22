InputStreamReader isr = new InputStreamReader(stream, "UTF-8");
StringBuilder sb = new StringBuilder();

    while (true)
    {
        int data = isr.read();

        if (data == -1) {
            break;
        } else {

            sb.append((char) data);

        }

    }