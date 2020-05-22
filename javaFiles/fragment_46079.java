Gson gson = new Gson();

Type dataType = (new TypeToken<Shoes>()
{
}).getType();

Shoes shoeList = gson.fromJson(jsonData, dataType);

for(Shoe e: shoeList.getShoes()) {
    System.out.println(e);
}