package com.aerospike.play;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;

public class StackOverflowQuestion {
    public static class Widgets implements Serializable{
        private static final String VIEW_FIELD = "view";
        private static final String CLICK_FIELD = "click";

        private int viewCount;
        private int clickCount;

        public Widgets(int viewCount, int clickCount) {
                this.viewCount = viewCount;
                this.clickCount = clickCount;
        }
        public int getViewCount() {
            return viewCount;
        }
        public int getClickCount() {
            return clickCount;
        }

        @Override
        public String toString() {
                return String.format("{view: %d, count: %s}", viewCount, clickCount);
        }

        public Map<String, Object> asMap() {
                Map<String, Object> values = new HashMap<>();
                values.put(VIEW_FIELD, this.viewCount);
                values.put(CLICK_FIELD, this.clickCount);
                return values;
        }

        public static Widgets fromMap(Map<String, Object> map) {
                return new Widgets((int)(long)map.get(VIEW_FIELD), (int)(long)map.get(CLICK_FIELD));
        }
    }

    public static void main(String[] args) {
        AerospikeClient client = new AerospikeClient("172.28.128.4", 3000);
        Key key = new Key( "test", "users", 2 );
        Map<Integer, Map<String, Object>> map = new HashMap<>();
        map.put(1, new Widgets(2, 2).asMap());
        map.put(2, new Widgets(3, 0).asMap());
        Bin bin = new Bin("widgets", map);
        client.put( null, key, bin );

        Record record = client.get(null, key); // using same key for testing
        Map<Long, Map<String, Object>> map2 = (Map<Long, Map<String, Object>>) record.getMap("widgets"); 
        map2.forEach( (k,v) -> {
            Widgets w = Widgets.fromMap(v);
            System.out.printf("%d -> %s\n", k, w);
        });

        client.close();
    }
}