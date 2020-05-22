ArrayList<Vehicle> vehicles = new ArrayList<>();

//This is just for show, here you would iterate through the data/cursor/etc
// that you get back from the sql query
for(Row row: rows) {
   vehicles.add(new Vehicle(Integer.parseInt(row.getColumn("id")),
                            row.getColumn("make").toString(),
                            row.getColumn("model").toString()
               );
}
 return vehicles;