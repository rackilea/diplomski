@Service
public class MySingleSingletonClass{

   public int methodA(){...}
}

@Service
public class ConsumerA{
   @Autowired
   private MySingleSingletonClass mssc;
}

@Service
public class ConsumerB{
   @Autowired
   private MySingleSingletonClass mssc;
}