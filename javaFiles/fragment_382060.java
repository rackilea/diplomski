@Autowired
List<Service> myServices;
public void processServices(){
    boolean completed = false;
    Iterator<Service> myServicesIter = myServices.iterator();
    while(myServicesIter.hasNext() && !completed){
        Service service = myServicesIter.next();
        completed = service.process();
    }
    if(!completed){
       throw Exception();
    }
}