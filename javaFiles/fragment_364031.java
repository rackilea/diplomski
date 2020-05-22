@XmlAccessorType(XmlAccessType.FIELD)
public class DepositLast3CycleResponse extends BaseResponseBean {

    @XmlElements(
            {
                    @XmlElement(name = "trans_1"),
                    @XmlElement(name = "trans_2"),
                    @XmlElement(name = "trans_3")
            }
    )
    private List<TransactionInfo> transactions;


    /****** getters and setters ****/
}