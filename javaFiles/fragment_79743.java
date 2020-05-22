public class Answer {
    private int requestId;
    private String newText; //variable is called newText, but getters and setters are named after a variable in Request.java, originalText

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getOriginalText() { //PAY ATTENTION TO NAME OF GETTER
        return newText;
    }

    public void setOriginalText(String newText) { //PAY ATTENTION TO NAME OF SETTER
        this.newText = newText;
    }
}