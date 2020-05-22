import com.google.appengine.api.memcache.MemcacheServicePb.MemcacheGetRequest;
import com.google.appengine.api.memcache.MemcacheServicePb.MemcacheGetResponse;
import com.google.appengine.api.memcache.MemcacheServicePb.MemcacheIncrementRequest;
import com.google.appengine.api.memcache.MemcacheServicePb.MemcacheIncrementResponse;
import com.google.appengine.api.memcache.MemcacheServicePb.MemcacheSetRequest;
import com.google.appengine.api.memcache.MemcacheServicePb.MemcacheSetResponse;
...

  private static void examineRequest(String pkg, String method, byte[] request) {
    try {
      if (pkg.equals("memcache")) {
        if (method.equals("Get")) {
          MemcacheGetRequest req = MemcacheGetRequest.parseFrom(request);
          for (Iterable<Byte> key : req.getKeyList()) {
            ... key ...
          }
        } else if (method.equals("Set")) {
          MemcacheSetRequest req = MemcacheSetRequest.parseFrom(request);
          for (MemcacheSetRequest.Item item : req.getItemList()) {
            ... item.getKey() ... item.getValue() ...
          }
        } else if (method.equals("Increment")) {
          MemcacheIncrementRequest req = MemcacheIncrementRequest.parseFrom(request);
          ... req.getKey()... req.getDelta()... req.getInitialValue() ... 
        }
      }
    } catch (IOException e) {
      ... 
    }
  }

  private static void examineResponse(String pkg, String method, byte[] response) {
    try {
      if (pkg.equals("memcache")) {
        if (method.equals("Get")) {
          MemcacheGetResponse resp = MemcacheGetResponse.parseFrom(response);
          for (MemcacheGetResponse.Item item : resp.getItemList()) {
            ... item.getKey() ... item.getValue() ...
          });

        } else if (method.equals("Set")) {
          MemcacheSetResponse resp = MemcacheSetResponse.parseFrom(response);
          ... resp.getSetStatusList() ... 

        } else if (method.equals("Increment")) {
          MemcacheIncrementResponse resp = MemcacheIncrementResponse.parseFrom(response);
          ... resp.getNewValue() ... 

        }
      }
    } catch (IOException e) {
      ... 
    }

  }