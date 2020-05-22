ArrayList<String> ran = new ArrayList<String>();

for (String x : getConfig().getConfigurationSection("item").getKeys(false)) {
    System.out.println(x + " oo");
    ran.add(x);
}