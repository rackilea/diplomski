List<Object[]> res = query.getResultList();
List<Equip> list= new ArrayList<Equip>();
JSONObject obj = new JSONObject();

Iterator it = res.iterator();
while(it.hasNext()){
     Object[] line = it.next();
     Equip eq = new Equip();
     eq.setIdEquipement(line[0]);
     eq.setTitre(line[1]);
     eq.setDescription(line[2]);
     //And set all the Equip fields here
     //And last thing add it to the list

     list.add(eq);
}