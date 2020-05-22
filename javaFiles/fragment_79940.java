public class UserInfo {
    private int domainId;
    private String id;
    private String status;

    public void setDomainId(int domainId) {
        this.domainId = domainId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (domainId != userInfo.domainId) return false;
        if (id != null ? !id.equals(userInfo.id) : userInfo.id != null) return false;
        if (status != null ? !status.equals(userInfo.status) : userInfo.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = domainId;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

}