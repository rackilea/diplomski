public static void main(String[] args) {

    File here = new File("");
    File[] contents = here.listFiles();

    for (int counter = 0; counter < contents.length; counter++) {
        System.out.println(contents[counter].getName());
    }

    File directory = here.getParentFile();
    System.out.println("The absolute path is" + directory.getAbsolutePath());
    File[] list = directory.listFiles();
    System.out.println("Directrory code contains" + list.length + "items\n.");

    System.out.println("----\n");

    for (int i = 0; i < list.length; i++) {
        if (list[i].isDirectory()) {
            System.out.println(list[i].getName() + "is a directory with" + list[i].listFiles().length + "elements");

        } else {
            System.out.println(list[i].getName() + "has a size of" + list[i].length() + "bytes.");
        }
    }
}