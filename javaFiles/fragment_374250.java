do {
    input = br.readLine();
    if (input.endsWith("\n")) {
        input = input.substring(0, input.indexOf("\n"));
    }
    System.out.println(input);
} while (br.read() != -1);