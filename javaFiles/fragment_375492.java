Boolean started = false;
while (scanner.hasNext()) {

    line = scanner.nextLine();
    if (line.startsWith("BGSTART")) {
        started = true;
        continue;
    }

    if (line.startsWith("BGEND")) {
        started = false;
        break;
    }

    if (started) // tag in the txt to locate position
    {
        System.out.println(line);//won't print on my console
        lb1.setText(line); //attaches to a JTextArea.
        window2.add(lb1); //adds to JPanel
    }
}
scanner.close();