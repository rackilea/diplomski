BreakfestFood bf = new BreakfestFood();
Food f1 = new Food();
f1.setName("f1Name");
f1.setCalories(20);
f1.setDescription("desc");
f1.setPrice(11.1);
bf.setFood(List.of(f1));

System.out.println(xmlMapper.writeValueAsString(bf));

Output: 
<breakfast_menu>
  <food>
    <food>
      <price>11.1</price>
      <description>desc</description>
      <calories>20</calories>
      <name>f1Name</name>
    </food>
  </food>
</breakfast_menu>