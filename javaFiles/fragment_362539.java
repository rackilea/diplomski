public static void main(String[] args) {
    Context context = new VelocityContext();
    context.put("appid", "9876543d1");
    context.put("ds", "2013-09-11");
    StringWriter sw = new StringWriter();
    String template = "APPID is ${appid} and DS is ${ds}";
    Velocity.evaluate(context, sw, "velocity", template);
    System.out.println(sw.toString());
}