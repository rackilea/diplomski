import java.util.HashMap;
import java.util.List;
import java.util.Map;
import urn.ebay.api.PayPalAPI.*;
import urn.ebay.apis.eBLBaseComponents.PaymentTransactionSearchResultType;

public class PaymentManager {

public static void main(String[] args) {

    Map<String,String> configMap = new HashMap<String,String>();

    configMap.put("mode", "live");

    // Account Credential
    configMap.put("acct1.UserName", "...");
    configMap.put("acct1.Password", "...");
    configMap.put("acct1.Signature", "...-...");
    // Subject is optional, only required in case of third party permission
    //configMap.put("acct1.Subject", "");

    // Sample Certificate credential
    // configMap.put("acct2.UserName", "certuser_biz_api1.paypal.com");
    // configMap.put("acct2.Password", "D6JNKKULHN3G5B8A");
    // configMap.put("acct2.CertKey", "password");
    // configMap.put("acct2.CertPath", "resource/sdk-cert.p12");
    // configMap.put("acct2.AppId", "APP-80W284485P519543T");


    TransactionSearchReq txnreq = new TransactionSearchReq();
    TransactionSearchRequestType requestType = new TransactionSearchRequestType();

    requestType.setStartDate("2018-04-01T00:00:00.000Z"); 
    requestType.setEndDate("2018-04-05T23:59:59.000Z"); 
    requestType.setVersion("95.0");
    requestType.setTransactionID("");
    txnreq.setTransactionSearchRequest(requestType);

    PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(configMap);

    try {
        TransactionSearchResponseType txnresponse = service.transactionSearch(txnreq, configMap.get("acct1.UserName"));

        List<PaymentTransactionSearchResultType> transactions = txnresponse.getPaymentTransactions();

        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i).getPayer());
        }

    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}