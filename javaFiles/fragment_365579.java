public static void main(String[] args) {

        String test = "\\ipAddress\\FolderA\\InnerFolderA\\abc.mp4";
        String output = test.replaceAll("\\\\", ":");
        System.out.println(output);

        String parts[] = test.split("\\\\");
        String part0 = parts[0];
        String part1 = parts[1];
        String part2 = parts[2];
        System.out.println(part0);
        System.out.println(part1);
        System.out.println(part2);

    }