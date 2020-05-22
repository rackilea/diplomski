public class Comment {
    private String commentId;
    private String commentedBy;
    private Date updateDate;
    private String commentText;

    public String getCommentId() {
        return commentId;
    }
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    public String getCommentedBy() {
        return commentedBy;
    }
    public void setCommentedBy(String commentedBy) {
        this.commentedBy = commentedBy;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public String getCommentText() {
        return commentText;
    }
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}