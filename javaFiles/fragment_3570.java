@JsonSerialize(using=MyStdSerializer.class)
public class Data implements Serializable{

     private static final long serialVersionUID = 2926346626990185211L;

        @JsonProperty("x")
        private Long date;

        @JsonProperty("y")
        private BigDecimal value;

        public Long getDate() {
            return date;
        }

        public void setDate(Long date) {
            this.date = date;
        }

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

}