@Component("programmer")
class Programmer implements IPerson {...}

@Component("lionTamer")
class LionTamer implements IPerson {...}

@Component
class SomethingThatDoesStuff { 

    @Autowired
    public SomethingThatDoesStuff (@Qualifier("programmer") IPerson someone) {
        ...
    }

}