package example.app.gemfire.cache;

import org.apache.geode.cache.CustomExpiry;
import org.apache.geode.cache.ExpirationAttributes;
import ...;

class MyCustomExpiry implements CustomExpiry<String, Object> {

  ExpirationAttributes getExpiry(Region.Entry<String, Object> entry) {
    ...
  }
}