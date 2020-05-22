@Service("child1service")
@Qualifier("child1service")
public class Child1 implements ParentService{}

@Service("child2service")
@Qualifier("child2service")
public class Child2 implements ParentService{}