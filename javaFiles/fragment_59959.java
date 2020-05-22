/**
 * 
 */
package test;

import java.util.ArrayList;

/**
 * @author 00990
 *
 */
public class TestDTO extends JsonObject {
    private String code;
    Data data;
    private String message;
    private String token;
    private float status;

    // Getter Methods

    public String getCode() {
        return code;
    }

    public Data getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public float getStatus() {
        return status;
    }

    // Setter Methods

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Data dataObject) {
        this.data = dataObject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(float status) {
        this.status = status;
    }


    public static void main(String[] args) {
        String jsonObj = "{\r\n" + "    \"code\": \"2075-4673\",\r\n" + "    \"data\": {\r\n"
                + "        \"requestId\": 4673,\r\n" + "        \"requestCode\": \"2075-4673\",\r\n"
                + "        \"fiscalYear\": {\r\n" + "            \"fiscalYearId\": 2075,\r\n"
                + "            \"fiscalYearCode\": \"2075/76\"\r\n" + "        },\r\n"
                + "        \"requestDate\": 1531851300000,\r\n" + "        \"requestNdate\": \"2075/04/02\",\r\n"
                + "        \"rcAgency\": {\r\n" + "            \"id\": 2373,\r\n"
                + "            \"code\": \"210003501\",\r\n" + "            \"rcAgencyEDesc\": \"ABC\",\r\n"
                + "            \"rcAgencyNDesc\": \" सेवा \",\r\n" + "            \"nepaliName\": \" सेवा\",\r\n"
                + "            \"engishName\": null\r\n" + "        },\r\n" + "        \"status\": 1,\r\n"
                + "        \"pan\": \"500127108\",\r\n" + "        \"payerCode\": null,\r\n"
                + "        \"payerEdesc\": \"ABC Enterprises\",\r\n" + "        \"payerNdesc\": null,\r\n"
                + "        \"payerAddress\": null,\r\n" + "        \"payerPhone\": null,\r\n"
                + "        \"totalAmount\": 14000,\r\n" + "        \"createdBy\": \"psctest\",\r\n"
                + "        \"createdOn\": 1531851300000,\r\n" + "        \"collectedBank\": null,\r\n"
                + "        \"collectedDate\": null,\r\n" + "        \"collectedBy\": null,\r\n"
                + "        \"token\": \"xxxxxxxxxxxxxxxx\",\r\n" + "        \"details\": [\r\n" + "            {\r\n"
                + "                \"ebpNo\": \"4977\",\r\n" + "                \"sno\": 1,\r\n"
                + "                \"depositSlipNo\": null,\r\n" + "                \"purpose\": null,\r\n"
                + "                \"revenueHead\": {\r\n" + "                    \"id\": 14224,\r\n"
                + "                    \"code\": \"14224\",\r\n" + "                    \"oldCode\": \"14224\",\r\n"
                + "                    \"nepaliName\": \"शुल्क\",\r\n"
                + "                    \"englishName\": \"शुल्क\",\r\n"
                + "                    \"description\": \"शुल्क\",\r\n"
                + "                    \"nepaliDescription\": \"शुल्क\",\r\n"
                + "                    \"preRevenueHeadId\": 0,\r\n" + "                    \"status\": true,\r\n"
                + "                    \"federal\": true,\r\n" + "                    \"state\": true,\r\n"
                + "                    \"local\": true,\r\n" + "                    \"remarks\": \"xxxxx\"\r\n"
                + "                },\r\n" + "                \"remarks\": \"remarks\",\r\n"
                + "                \"description\": \"Production\",\r\n" + "                \"currency\": {\r\n"
                + "                    \"currencyId\": 524,\r\n" + "                    \"currencyCode\": \"524\",\r\n"
                + "                    \"descEnglish\": \"NRS\",\r\n"
                + "                    \"descNepali\": \"NRS\"\r\n" + "                },\r\n"
                + "                \"amount\": 14000,\r\n" + "                \"taxAdv\": false,\r\n"
                + "                \"taxyearId\": 2074,\r\n" + "                \"dueAmount\": 14000,\r\n"
                + "                \"createdBy\": \"psctest\",\r\n" + "                \"createdOn\": 1531894162000\r\n"
                + "            }\r\n" + "        ]\r\n" + "    },\r\n"
                + "    \"message\": \"Voucher has saved sucessfully.\",\r\n"
                + "    \"token\": \"xxxxxxxxxxxxxxxxxxxx\",\r\n" + "    \"status\": 0\r\n" + "}";
        System.out.println("Token :" +((TestDTO) new TestDTO().toObject(jsonObj)).getToken());
        System.out.println(" PAN  :" +((TestDTO) new TestDTO().toObject(jsonObj)).getData().getPan());
        System.out.println("EBPNo :" +((TestDTO) new TestDTO().toObject(jsonObj)).getData().getDetails().get(0).getEbpNo());
    }
}

class Data extends JsonObject {
    private float requestId;
    private String requestCode;
    FiscalYear FiscalYearObject;
    private float requestDate;
    private String requestNdate;
    RcAgency RcAgencyObject;
    private float status;
    private String pan;
    private String payerCode = null;
    private String payerEdesc;
    private String payerNdesc = null;
    private String payerAddress = null;
    private String payerPhone = null;
    private float totalAmount;
    private String createdBy;
    private float createdOn;
    private String collectedBank = null;
    private String collectedDate = null;
    private String collectedBy = null;
    private String token;
    ArrayList<Detail> details = new ArrayList<Detail>();

    // Getter Methods

    public float getRequestId() {
        return requestId;
    }

    public ArrayList<Detail> getDetails() {
        return details;
    }

    public void addToDetails(Detail detail) {
        if (details == null) {
            details = new ArrayList<Detail>();
        }
        this.details.add(detail);
    }

    public String getRequestCode() {
        return requestCode;
    }

    public FiscalYear getFiscalYear() {
        return FiscalYearObject;
    }

    public float getRequestDate() {
        return requestDate;
    }

    public String getRequestNdate() {
        return requestNdate;
    }

    public RcAgency getRcAgency() {
        return RcAgencyObject;
    }

    public float getStatus() {
        return status;
    }

    public String getPan() {
        return pan;
    }

    public String getPayerCode() {
        return payerCode;
    }

    public String getPayerEdesc() {
        return payerEdesc;
    }

    public String getPayerNdesc() {
        return payerNdesc;
    }

    public String getPayerAddress() {
        return payerAddress;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public float getCreatedOn() {
        return createdOn;
    }

    public String getCollectedBank() {
        return collectedBank;
    }

    public String getCollectedDate() {
        return collectedDate;
    }

    public String getCollectedBy() {
        return collectedBy;
    }

    public String getToken() {
        return token;
    }

    // Setter Methods

    public void setRequestId(float requestId) {
        this.requestId = requestId;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public void setFiscalYear(FiscalYear fiscalYearObject) {
        this.FiscalYearObject = fiscalYearObject;
    }

    public void setRequestDate(float requestDate) {
        this.requestDate = requestDate;
    }

    public void setRequestNdate(String requestNdate) {
        this.requestNdate = requestNdate;
    }

    public void setRcAgency(RcAgency rcAgencyObject) {
        this.RcAgencyObject = rcAgencyObject;
    }

    public void setStatus(float status) {
        this.status = status;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public void setPayerCode(String payerCode) {
        this.payerCode = payerCode;
    }

    public void setPayerEdesc(String payerEdesc) {
        this.payerEdesc = payerEdesc;
    }

    public void setPayerNdesc(String payerNdesc) {
        this.payerNdesc = payerNdesc;
    }

    public void setPayerAddress(String payerAddress) {
        this.payerAddress = payerAddress;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedOn(float createdOn) {
        this.createdOn = createdOn;
    }

    public void setCollectedBank(String collectedBank) {
        this.collectedBank = collectedBank;
    }

    public void setCollectedDate(String collectedDate) {
        this.collectedDate = collectedDate;
    }

    public void setCollectedBy(String collectedBy) {
        this.collectedBy = collectedBy;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

class RcAgency extends JsonObject {
    private float id;
    private String code;
    private String rcAgencyEDesc;
    private String rcAgencyNDesc;
    private String nepaliName;
    private String engishName = null;

    // Getter Methods

    public float getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getRcAgencyEDesc() {
        return rcAgencyEDesc;
    }

    public String getRcAgencyNDesc() {
        return rcAgencyNDesc;
    }

    public String getNepaliName() {
        return nepaliName;
    }

    public String getEngishName() {
        return engishName;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRcAgencyEDesc(String rcAgencyEDesc) {
        this.rcAgencyEDesc = rcAgencyEDesc;
    }

    public void setRcAgencyNDesc(String rcAgencyNDesc) {
        this.rcAgencyNDesc = rcAgencyNDesc;
    }

    public void setNepaliName(String nepaliName) {
        this.nepaliName = nepaliName;
    }

    public void setEngishName(String engishName) {
        this.engishName = engishName;
    }
}

class FiscalYear extends JsonObject {
    private float fiscalYearId;
    private String fiscalYearCode;

    // Getter Methods

    public float getFiscalYearId() {
        return fiscalYearId;
    }

    public String getFiscalYearCode() {
        return fiscalYearCode;
    }

    // Setter Methods

    public void setFiscalYearId(float fiscalYearId) {
        this.fiscalYearId = fiscalYearId;
    }

    public void setFiscalYearCode(String fiscalYearCode) {
        this.fiscalYearCode = fiscalYearCode;
    }


}