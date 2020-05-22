import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "table_name")
public class TransactionByFop
        extends BaseTransaction
{
    @ManyToOne
    private Transaction transaction;


    private int reject;

    //transbank context: TBK_ID_TRANSACCION; CAT context: IdCarro
    @Column(name = "column_name")
    private Long internalTransactionId;

    //transbank context: TBK_TIPO_PAGO; CAT context: no es usado dejar en blanco
    @Column(name = "column_name")
    private String internalPaymentType;

    //transbank context: TBK_NUMERO_CUOTAS; CAT context: NumeroCuotas
    @Column(name = "column_name")
    private Integer installmentsNumber;

    //transbank context: no es usado dejar en blanco; CAT context: MontoCuota
    @Column(name = "column_name")
    private Double installmentsAmount;

    //transbank context: TBK_FECHA_TRANSACCION; CAT context: FechaHoraAutorizacion
    @Column(name = "column_name")
    private Date authDate;

    //transbank context: TBK_FINAL_NUMERO_TARJETA; CAT context: corresponde al número completo de la tarjeta si la transacción fué autorizada sin el password de seguridad, de lo contrario dejarlo en blanco.
    @Column(name = "column_name")
    private String creditCardNumber;

    //transbank context: no es usado dejar en blanco; CAT context: Esta información no es explícita, pero puede ser deducida basada en alguna información
    @Column(name  = "column_name")
    private Boolean catSecureKeyFlag;

    //transbank context: no es usado dejar en blanco; CAT context: Viene basado en si el cliente está usando la clave de seguridad de lo contrario se deja en blanco
    private String catCustomerRUT;

    private String currency;

    private Double discountedAmount;

    public Transaction getTransaction()
    {
        return transaction;
    }

    public void setTransaction(Transaction transaction)
    {
        this.transaction = transaction;
    }

    public int getReject()
    {
        return reject;
    }

    public void setReject(int reject)
    {
        this.reject = reject;
    }

    public Long getInternalTransactionId()
    {
        return internalTransactionId;
    }

    public void setInternalTransactionId(Long internalTransactionId)
    {
        this.internalTransactionId = internalTransactionId;
    }

    public String getInternalPaymentType()
    {
        return internalPaymentType;
    }

    public void setInternalPaymentType(String internalPaymentType)
    {
        this.internalPaymentType = internalPaymentType;
    }

    public Double getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(Double discountedAmount) {
        this.discountedAmount = discountedAmount;
    }


    public Integer getInstallmentsNumber()
    {
        return installmentsNumber;
    }

    public void setInstallmentsNumber(Integer installmentsNumber)
    {
        this.installmentsNumber = installmentsNumber;
    }

    public Double getInstallmentsAmount()
    {
        return installmentsAmount;
    }

    public void setInstallmentsAmount(Double installmentsAmount)
    {
        this.installmentsAmount = installmentsAmount;
    }

    public Date getAuthDate()
    {
        return authDate;
    }

    public void setAuthDate(Date authDate)
    {
        this.authDate = authDate;
    }

    public String getCreditCardNumber()
    {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber)
    {
        this.creditCardNumber = creditCardNumber;
    }

    public Boolean getCatSecureKeyFlag()
    {
        return catSecureKeyFlag;
    }

    public void setCatSecureKeyFlag(Boolean catSecureKeyFlag)
    {
        this.catSecureKeyFlag = catSecureKeyFlag;
    }

    public String getCatCustomerRUT()
    {
        return catCustomerRUT;
    }

    public void setCatCustomerRUT(String catCustomerRUT)
    {
        this.catCustomerRUT = catCustomerRUT;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAuthDateFormatted()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = null;
        if (null != this.authDate)
            stringDate = sdf.format(this.authDate);
        return stringDate;
    }

    public String getInstallmentsNumberFmt()
    {
        if (null == this.installmentsNumber || this.installmentsNumber == 0)
            return "00";
        String installments = this.installmentsNumber.toString();
        if (installments.length() == 1)
            return "0" + installments;
        return installments;
    }

    public String getInstallmentsAmountFmt()
    {
        if (null != this.installmentsAmount)
            return this.installmentsAmount.toString();
        return "";
    }

    public String getCatSecureKeyFlagFmt()
    {
        if (null != catSecureKeyFlag)
            return catSecureKeyFlag.toString();
        return null;
    }

    @Override
    public String toString()
    {
        return "[ id (" + id + ") : amount(" + amount +
                ") : id_fop(" + (fop == null
                                 ? ""
                                 : fop.getId()) + ") : " +
                ") : last_update=(" + lastUpdate + ") : " +
                ") : settled(" + settled + ") : settled_amount(" + settledAmount +
                ") : id_status(" + (status == null
                                    ? ""
                                    : status.getId()) + ")]";
    }
}