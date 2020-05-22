String str = "[255,12,87,183,232,34,64,121,182,23]";
Gson gson = new Gson();
byte[] parsed = gson.fromJson(str, byte[].class);
for (byte b : parsed) {
    System.out.println(b);
}