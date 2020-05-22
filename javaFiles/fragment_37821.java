@Autowired //don't forget the setter
    private ModeRepository repository; 

    @RequestMapping("/mode")
    public String showProducts(){
        Mode m = new Mode();
        m.setSeats(2);
        repository.save(m); //this is where the error getting from
        return "product";
    }