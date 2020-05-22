@JsonInclude(value = Include.NON_EMPTY)
public class AjaxResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private long draw;

    private long recordsTotal;

    private long recordsFiltered;

    private List<Object> data = new ArrayList<>();

    private String error;

    public AjaxResponse() {

    }

    public AjaxResponse(int draw) {
        this.draw = draw;
    }

    public long getDraw() {
        return draw;
    }

    public void setDraw(long draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}