String name = entry.getName();
boolean notInFiles = true;
for (File f : contents) {
    System.out.println("f is " + f);
    if (name.equals("/conf/" + f.getName()) {
        // that file is already inside the jar file
        notInFiles = false;
        System.out.println("file already inside the jar file");
        break;
    }
}