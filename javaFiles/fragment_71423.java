String img1 = "https://cdn.dnaindia.com/sites/default/files/styles/full/public/2018/03/08/658858-577200-katrina-kaif-052217.jpg";
String img2 = "https://cdn.somethinghaute.com/wp-content/uploads/2018/07/katrina-kaif.jpg";

con.setRequestMethod("POST");
con.setDoOutput(true);

con.setRequestProperty("user_id", myid);
con.setRequestProperty("user_key", thekey);

con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

String body = 
    "img_1=" + URLEncoder.encode(img1, "UTF-8") + "&" +
    "img_2=" + URLEncoder.encode(img2, "UTF-8");

try (OutputStream os = con.getOutputStream()) {
    byte[] input = body.getBytes(StandardCharsets.UTF_8);
    os.write(input);
}