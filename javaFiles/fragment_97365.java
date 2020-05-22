public class MachineRepoImpl implements MachineRepoCustom {

@Autowired
private MachineRepo machineRepo;

@Autowired
private ApplicationContext applicationContext;

@Override
public List<Machine> findMonitorables() {
    List<Machine> machines = machineRepo.findAll();
    Map<String, Monitorable> beansOfType = applicationContext.getBeansOfType(Monitorable.class);
    Collection<Monitorable> monitorables = beansOfType.values();
    Set<Class<? extends Monitorable>> set = new HashSet<>(); 
    List<Machine> result = new ArrayList<Machine>();

    // parses monitorable classes
    for(Monitorable m : monitorables)
    {
        set.add(m.getClass());
    }

    // checks whether the entry in the table is monitorable 
    for (Machine machine : machines) {
        if (set.contains(machine.getClass())) {
            result.add(machine);
        }
    }
    return result;
}