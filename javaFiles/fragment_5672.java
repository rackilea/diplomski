public class SuccessTransaction implements TransactionResult{
private String resultStatus;

public SuccessTransaction() { this.resultStatus = "success"; }

public void writeLog() { System.out.println(this.resultStatus); } //or whatever you want to do with your result

}