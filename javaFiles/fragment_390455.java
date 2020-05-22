public class AjaxRequest implements Serializable {

    public static class Column {

        private int index;

        private String data;

        private String name;

        private boolean searchable;

        private boolean orderable;

        private String searchValue;

        private boolean searchRegex;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSearchable() {
            return searchable;
        }

        public void setSearchable(boolean searchable) {
            this.searchable = searchable;
        }

        public boolean isOrderable() {
            return orderable;
        }

        public void setOrderable(boolean orderable) {
            this.orderable = orderable;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public boolean isSearchRegex() {
            return searchRegex;
        }

        public void setSearchRegex(boolean searchRegex) {
            this.searchRegex = searchRegex;
        }
    }

    public static class Order {

        private int index;

        private int column;

        private OrderDirection dir;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public OrderDirection getDir() {
            return dir;
        }

        public void setDir(OrderDirection dir) {
            this.dir = dir;
        }
    }

    public enum OrderDirection {
        asc, desc;
    }

    private static final long serialVersionUID = 1L;

    private Integer draw;

    private Integer start;

    private Integer length;

    private String searchValue;

    private boolean searchRegex;

    private List<Column> columns = new LinkedList<>();

    private List<Order> orders = new LinkedList<>();

    public AjaxRequest() {

    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public boolean isSearchRegex() {
        return searchRegex;
    }

    public void setSearchRegex(boolean searchRegex) {
        this.searchRegex = searchRegex;
    }

    public List<Column> _getColumns() {
        return columns;
    }

    public List<Order> _getOrders() {
        return orders;
    }

    public void bind(HttpServletRequest request) {
        String searchRegexParam = request.getParameter("search[regex]");

        this.searchValue = request.getParameter("search[value]");

        if (StringUtils.isNotBlank(searchRegexParam)) {
            this.searchRegex = searchRegexParam.equals("true");
        }

        for (int i = 0;; i++) {
            String cDataParam = request.getParameter("columns[" + i + "][data]");
            String cNameParam = request.getParameter("columns[" + i + "][name]");
            String cSearchableParam = request.getParameter("columns[" + i + "][searchable]");
            String cOrderableParam = request.getParameter("columns[" + i + "][orderable]");
            String cSearchValueParam = request.getParameter("columns[" + i + "][search][value]");
            String cSearchRegexParam = request.getParameter("columns[" + i + "][search][regex]");

            // No more columns
            if (cDataParam == null) {
                break;
            }

            Column column = new Column();
            column.setIndex(i);
            column.setData(cDataParam);
            column.setName(cNameParam);
            column.setSearchable(StringUtils.equals(cSearchableParam, "true"));
            column.setOrderable(StringUtils.equals(cOrderableParam, "true"));
            column.setSearchValue(cSearchValueParam);
            column.setSearchRegex(StringUtils.equals(cSearchRegexParam, "true"));

            this.columns.add(column);
        }

        for (int i = 0;; ++i) {
            String orderColumnIdx = request.getParameter("order[" + i + "][column]");

            if (StringUtils.isEmpty(orderColumnIdx)) {
                break;
            }

            String orderDirection = request.getParameter("order[" + i + "][dir]");

            if (StringUtils.isEmpty(orderDirection)) {
                break;
            }

            Order order = new Order();
            order.setIndex(i);
            order.setColumn(Integer.valueOf(orderColumnIdx));
            order.setDir(OrderDirection.valueOf(orderDirection));

            this.orders.add(order);
        }
    }
}