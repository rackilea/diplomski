try (PrintWriter output = new PrintWriter(threadSocket.getOutputStream(), true)) {
    try (BufferedReader input = new BufferedReader(new InputStreamReader(threadSocket.getInputStream()))) {

        while (true) {
            output.println("You have connected at: " + new Date());
            textArea.append("\nClient connected\n");
            temp = input.readLine();

            if (temp != null) {

                if (temp.equals("add")) {
                    synchronized (this) {
                        ctr++;
                        textArea.append(Integer.toString(ctr));
                        output.println(ctr);
                    }
                }

            }

        }

    }
} catch (IOException exp) {
    exp.printStackTrace();
}