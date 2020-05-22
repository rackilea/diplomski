boolean partB = false;
content = fw.readLine();
while(content != null) {
    if(content.equals("[PartA]")) {
        partB = false;
    } else if (content.equals("[PartB]")) {
        partB = true;
    } else if (content.equals("[PartC]")) {
        partB = false;
    }
    if (partB) {
        System.out.println(content);
    }
    content = fw.readLine();
}