import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonProgram {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Root root = mapper.readValue(json, Root.class);
        System.out.println(root.getTop10());
    }
}

class Root {

    @JsonProperty("Top10BidAsks")
    private List<MarketDataEntity> top10;

    public List<MarketDataEntity> getTop10() {
        return top10;
    }

    public void setTop10(List<MarketDataEntity> top10) {
        this.top10 = top10;
    }
}

class MarketDataEntity {

    private Map<String, MarketData> datas = new HashMap<String, MarketData>();

    @JsonAnySetter
    public void setMarketData(String key, MarketData data) {
        datas.put(key, data);
    }

    @Override
    public String toString() {
        return datas.toString();
    }
}

class MarketData {

    @JsonProperty("Price")
    private BigDecimal price;

    @JsonProperty("Size")
    private BigDecimal size;

    @JsonProperty("ExchangeID")
    private String exchangeId;

    private int timeStamp;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "MarketData [price=" + price + ", size=" + size + ", exchangeId=" + exchangeId + ", timeStamp=" + timeStamp + "]";
    }
}