package  test;

public class Detail extends JsonObject {
     private String ebpNo;
     private float sno;
     private String depositSlipNo = null;
     private String purpose = null;
     RevenueHead RevenueHeadObject;
     private String remarks;
     private String description;
     Currency CurrencyObject;
     private float amount;
     private boolean taxAdv;
     private float taxyearId;
     private float dueAmount;
     private String createdBy;
     private float createdOn;


     // Getter Methods 

     public String getEbpNo() {
      return ebpNo;
     }

     public float getSno() {
      return sno;
     }

     public String getDepositSlipNo() {
      return depositSlipNo;
     }

     public String getPurpose() {
      return purpose;
     }

     public RevenueHead getRevenueHead() {
      return RevenueHeadObject;
     }

     public String getRemarks() {
      return remarks;
     }

     public String getDescription() {
      return description;
     }

     public Currency getCurrency() {
      return CurrencyObject;
     }

     public float getAmount() {
      return amount;
     }

     public boolean getTaxAdv() {
      return taxAdv;
     }

     public float getTaxyearId() {
      return taxyearId;
     }

     public float getDueAmount() {
      return dueAmount;
     }

     public String getCreatedBy() {
      return createdBy;
     }

     public float getCreatedOn() {
      return createdOn;
     }

     // Setter Methods 

     public void setEbpNo(String ebpNo) {
      this.ebpNo = ebpNo;
     }

     public void setSno(float sno) {
      this.sno = sno;
     }

     public void setDepositSlipNo(String depositSlipNo) {
      this.depositSlipNo = depositSlipNo;
     }

     public void setPurpose(String purpose) {
      this.purpose = purpose;
     }

     public void setRevenueHead(RevenueHead revenueHeadObject) {
      this.RevenueHeadObject = revenueHeadObject;
     }

     public void setRemarks(String remarks) {
      this.remarks = remarks;
     }

     public void setDescription(String description) {
      this.description = description;
     }

     public void setCurrency(Currency currencyObject) {
      this.CurrencyObject = currencyObject;
     }

     public void setAmount(float amount) {
      this.amount = amount;
     }

     public void setTaxAdv(boolean taxAdv) {
      this.taxAdv = taxAdv;
     }

     public void setTaxyearId(float taxyearId) {
      this.taxyearId = taxyearId;
     }

     public void setDueAmount(float dueAmount) {
      this.dueAmount = dueAmount;
     }

     public void setCreatedBy(String createdBy) {
      this.createdBy = createdBy;
     }

     public void setCreatedOn(float createdOn) {
      this.createdOn = createdOn;
     }
    }
 class Currency extends JsonObject {
     private float currencyId;
     private String currencyCode;
     private String descEnglish;
     private String descNepali;


     // Getter Methods 

     public float getCurrencyId() {
      return currencyId;
     }

     public String getCurrencyCode() {
      return currencyCode;
     }

     public String getDescEnglish() {
      return descEnglish;
     }

     public String getDescNepali() {
      return descNepali;
     }

     // Setter Methods 

     public void setCurrencyId(float currencyId) {
      this.currencyId = currencyId;
     }

     public void setCurrencyCode(String currencyCode) {
      this.currencyCode = currencyCode;
     }

     public void setDescEnglish(String descEnglish) {
      this.descEnglish = descEnglish;
     }

     public void setDescNepali(String descNepali) {
      this.descNepali = descNepali;
     }
    }
 class RevenueHead extends JsonObject {
     private float id;
     private String code;
     private String oldCode;
     private String nepaliName;
     private String englishName;
     private String description;
     private String nepaliDescription;
     private float preRevenueHeadId;
     private boolean status;
     private boolean federal;
     private boolean state;
     private boolean local;
     private String remarks;


     // Getter Methods 

     public float getId() {
      return id;
     }

     public String getCode() {
      return code;
     }

     public String getOldCode() {
      return oldCode;
     }

     public String getNepaliName() {
      return nepaliName;
     }

     public String getEnglishName() {
      return englishName;
     }

     public String getDescription() {
      return description;
     }

     public String getNepaliDescription() {
      return nepaliDescription;
     }

     public float getPreRevenueHeadId() {
      return preRevenueHeadId;
     }

     public boolean getStatus() {
      return status;
     }

     public boolean getFederal() {
      return federal;
     }

     public boolean getState() {
      return state;
     }

     public boolean getLocal() {
      return local;
     }

     public String getRemarks() {
      return remarks;
     }

     // Setter Methods 

     public void setId(float id) {
      this.id = id;
     }

     public void setCode(String code) {
      this.code = code;
     }

     public void setOldCode(String oldCode) {
      this.oldCode = oldCode;
     }

     public void setNepaliName(String nepaliName) {
      this.nepaliName = nepaliName;
     }

     public void setEnglishName(String englishName) {
      this.englishName = englishName;
     }

     public void setDescription(String description) {
      this.description = description;
     }

     public void setNepaliDescription(String nepaliDescription) {
      this.nepaliDescription = nepaliDescription;
     }

     public void setPreRevenueHeadId(float preRevenueHeadId) {
      this.preRevenueHeadId = preRevenueHeadId;
     }

     public void setStatus(boolean status) {
      this.status = status;
     }

     public void setFederal(boolean federal) {
      this.federal = federal;
     }

     public void setState(boolean state) {
      this.state = state;
     }

     public void setLocal(boolean local) {
      this.local = local;
     }

     public void setRemarks(String remarks) {
      this.remarks = remarks;
     }
}