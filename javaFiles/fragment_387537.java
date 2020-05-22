Pokemon pokemon1;
Pokemon pokemon2;
pokemon1 = arrayList.get(Math.random()*arrayList.size());
do {
    pokemon2 = arrayList.get(Math.random()*arrayList.size());
} while(pokemon1.getId() == pokemon2.getId());