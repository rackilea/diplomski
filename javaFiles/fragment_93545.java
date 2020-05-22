public class BaseService extends Service {
        public void onCreate() {
            super.onCreate();

            if( // cache is not installed ) {
                // install the cache
            }
            getApplication().incrementInstanceCount();
        }

        public void onDestroy() {
            super.onDestroy();

            if( getApplication().decrementInstanceCount() == 0) {
                // close the cache
            } else {
                // flush the cache
            }
        }
    }