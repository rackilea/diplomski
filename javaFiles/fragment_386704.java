@Service
        public class EmpServiceImpl implements EmpService {
            @Autowired
            private EmpRepository empRepository;

            @Override
            public List<Emp> findAll() {

                List<Emp> emps= new ArrayList<>();
                empRepository.findAll().forEach((e -> emps.add(e)));

                return emps;
            }
        }

        @Repository
        public interface EmpRepository  extends JpaRepository<Emp, Integer> {

        }