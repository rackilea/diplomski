import java.util.Date;

public class Article {

    protected int id;

    protected String guid;
    protected String title;
    protected String link;
    protected Date pubDate;
    protected String category;
    protected String description;
    protected String body;
    protected String comments;

    protected Article (String articleTitle, String articleBody) {
        title = articleTitle;
        body = articleBody;
    }

    protected Article (String guid, String articleTitle, String articleLink,
            long publicationDate, String category, String description,
            String articleBody, String commentsLink) {
        this(articleTitle, articleBody);
        this.guid = guid;
        this.link = articleLink;
        this.pubDate = new Date(publicationDate);
        this.category = category;
        this.description = description;
        this.comments = commentsLink;
    }

    protected Article (int id, String guid, String articleTitle, String articleLink,
            long publicationDate, String category, String description,
            String articleBody, String commentsLink) {
        this(guid, articleTitle, articleLink, publicationDate, 
                category, description, articleBody, commentsLink);
        this.id = id;
    }

    protected int getId() {
        return id;
    }

    protected String getTitle() {
        return title;
    }

    protected String getGuid() {
        return guid;
    }

    protected String getLink() {
        return link;
    }

    protected String getComments() {
        return comments;
    }

    protected String getCategory() {
        return category;
    }

    protected String getDescription() {
        return description;
    }

    protected String getBody() {
        return body;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected void setGuid(String guid) {
        this.guid = guid;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected void setLink(String link) {
        this.link = link;
    }

    protected void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    protected void setCategory(String category) {
        this.category = category;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected void setBody(String body) {
        this.body = body;
    }

    protected void setComments(String comments) {
        this.comments = comments;
    }

}