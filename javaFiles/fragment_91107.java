@RestController
@RequestMapping(value = "/Category")
@Slf4j 
public class CategoryController { 
@Autowired CategoryRepository categoryRepository; 
@RequestMapping(value = "/all", method = RequestMethod.GET) 
@ResponseBody 
public String getCategoryList() { 
List<String> sj = new ArrayList<String>(); //
List<CategoryProjection> all= this.categoryRepository.findByCategory();
List<CategoryProjection> list = this.categoryRepository.findByCategory(); 
// loop i 
for (int i = 0; i < list.size(); i++) { sj.add(list.get(i).getLev1() + " - " + list.get(i).getLev2()+ " - "+list.get(i).getLev3() + " - " + list.get(i).getLev4()); } 
String all = sj.stream().collect(Collectors.joining("<br>")); 
System.out.println(all); 
return all; 
//log.info(query); //return "Test"; 
}