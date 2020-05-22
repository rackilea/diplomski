public class BaseService extends Service {
    public void onDestroy() {
        super.onDestroy();

        HttpResponseCache cache = HttpResponseCache.getInstalled();
        if (cache != null) {
            cache.flush();
        }
    }
}

public class MyService extends BaseService {
    ....
}