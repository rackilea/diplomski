public static void main(String[] args) throws FileNotFoundException {
    Gson gson = new Gson();
    String json = readFromFile(new File("json.txt"));
    GObj result = gson.fromJson(json, GObj.class);
    System.out.println(result);
}

static String readFromFile(File file) throws FileNotFoundException {
    Scanner scanner = new Scanner(new FileInputStream(file));
    StringBuilder builder = new StringBuilder();
    while (scanner.hasNext()) {
        builder.append(scanner.nextLine());
    }
    scanner.close();
    return builder.toString();
}

static class GObj {
    public LinkedList<Role> getJsonTableResult;
    @Override
    public String toString() {return "GObj [getJsonTableResult=" + getJsonTableResult + "]";}
}

static class Role {
    public String RoleId;
    public String ShortDesc;
    @Override
    public String toString() {return "Role [RoleId=" + RoleId + ", ShortDesc=" + ShortDesc + "]";}
}