public class JsonParser {
    public static Response toJavaObject(String str) {
        String[] fields = str.split(",");
        Response res = new Response();
        res.setId(Integer.valueOf(fields[0].substring(1)));
        res.setType(fields[1].replaceAll("\"", ""));
        Details dtl = new Details();
        dtl.setId(Long.valueOf(fields[2].substring(1)));
        dtl.setTimestamp(Long.valueOf(fields[3]));
        dtl.setAmount(Double.valueOf(fields[4]));
        dtl.setPrice(Double.valueOf(fields[5].substring(0, fields[5].length() - 2)));
        res.setDetails(dtl);

        return res;
    }
}

class Details {
    public Long id;
    public Long timestamp;
    public Double amount;
    public Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

class Response {
    public Integer id;
    public String type;
    public Details details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}