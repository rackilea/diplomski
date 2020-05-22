@Service
public class ServiceImpl implements Service {

@Value("${spring.app.serviceName}") 
public String serviceName;

}