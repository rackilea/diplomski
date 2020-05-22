String data = new Scanner(new File("input.txt")).useDelimiter("\\A").next();

Gson gson = new Gson();
Season season = gson.fromJson(data, Season.class);

//test
System.out.println(season.getName());
System.out.println("-------");
for (Episode ep : season.getEpisodes())
    System.out.println(ep.getEpisode_number()+"\t"+ep.getName());