@Service
abstract class BaseService {

    void invoke(ServiceContext context) {

        // ...
        Response rsp = process(context);
        // ...

    }

    abstract Response process(ServiceContext context);
}