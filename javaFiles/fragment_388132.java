@Service
@Transactional
public class SpecificClass {
  // write your method, everyone of them will be transactional
  // and there will be  a commit in case of success or rollback in case of exception
}