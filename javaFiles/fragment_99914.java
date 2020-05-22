import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SalesTransactionTax {

    private String code;
    private BigDecimal rate;
    private Boolean isFixed;
    private BigDecimal taxAmount;
    private List<SalesTransactionTax> salesTransactionTaxList = null;

    public SalesTransactionTax(String code, BigDecimal rate, Boolean isFixed, BigDecimal taxAmount) { // NO_UCD
        this.code = code;
        this.rate = rate;
        this.isFixed = isFixed;
        this.taxAmount = taxAmount;
    }

    public SalesTransactionTax() {
        this.salesTransactionTaxList = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Boolean getIsFixed() {
        return isFixed;
    }

    public void setFixed(Boolean fixed) {
        isFixed = fixed;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void add(SalesTransactionTax inputValue) {
        SalesTransactionTax salesTransactionTax = checkInList(inputValue);
        if (salesTransactionTax != null) {
            // To sum operations the method used is add() from BigDecimal
            salesTransactionTax.setTaxAmount(salesTransactionTax.getTaxAmount().add(inputValue.getTaxAmount()));
        } else {
            this.salesTransactionTaxList.add(inputValue);
        }
    }

private SalesTransactionTax checkInList(SalesTransactionTax stt) {
    return salesTransactionTaxList.stream()
            // To compare String is used equals()
            .filter(stt2 -> stt2.getCode().equals(stt.getCode()))
            // To compare BigDecimal is used compareTo()
            .filter(stt2 -> stt2.getRate().compareTo(stt.getRate()) == 0)
            // To compare boolean is used ==
            .filter(stt2 -> stt2.getIsFixed() == stt.getIsFixed())
            // If doesn't exist return null
            .findAny().orElse(null);
}

    public void print() {
        salesTransactionTaxList.forEach(System.out::println);
    }

    @Override
    public String toString() {
        //Output formatted
        DecimalFormat df = new DecimalFormat("#,###.000");
        return code + ", " + df.format(new BigDecimal(String.valueOf(rate))) + ", " + isFixed + ", " + df.format(new BigDecimal(String.valueOf(taxAmount)));
    }

    public static void main(String[] args) {

        SalesTransactionTax mergeTaxes = new SalesTransactionTax();
        mergeTaxes.add(new SalesTransactionTax("VAT_1", BigDecimal.valueOf(5.000), true, BigDecimal.valueOf(1.100)));
        mergeTaxes.add(new SalesTransactionTax("VAT_1", BigDecimal.valueOf(5.000), true, BigDecimal.valueOf(1.100)));
        mergeTaxes.add(new SalesTransactionTax("VAT_2", BigDecimal.valueOf(9.000), true, BigDecimal.valueOf(2.200)));
        mergeTaxes.add(new SalesTransactionTax("VAT_2", BigDecimal.valueOf(9.000), true, BigDecimal.valueOf(2.200)));
        mergeTaxes.add(new SalesTransactionTax("VAT_2", BigDecimal.valueOf(9.000), true, BigDecimal.valueOf(2.200)));
        mergeTaxes.add(new SalesTransactionTax("VAT_2", BigDecimal.valueOf(9.000), false, BigDecimal.valueOf(9.500)));
        mergeTaxes.add(new SalesTransactionTax("VAT_3", BigDecimal.valueOf(7.000), true, BigDecimal.valueOf(1.000)));
        mergeTaxes.print();
    }

}