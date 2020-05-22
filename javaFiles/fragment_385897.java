public class ResponseBean {
    private List<ResponseElementBean> elitFileBasic;

    public List<ResponseElementBean> getElitFileBasic() {
        return this.elitFileBasic;
    }

    public void setElitFileBasic(List<ResponseElementBean> elitFileBasic) {
        this.elitFileBasic = elitFileBasic;
    }
}

public class ResponseElementBean {
    private String application;
    private fileName;

    // Getters and setters
    (...)
}