public class FacebookGroupSuggestion implements Suggestion {

    private String groupId;

    private Icon icon;

    public FacebookGroupSuggestion(String groupId) {
        this.groupId = groupId;
    }

    public String getDisplayString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<b>");
        builder.append(this.groupId);
        builder.append("</b>");
        if (this.icon != null) {
            builder.append(this.icon.toSafeHtml());
        }
        return builder.toString();
    }
}