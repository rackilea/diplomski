public interface ConditionFormatter {
    public String getCondition();
    public String applyFormatTo(String text);
    public boolean matches(String text);
}

public class DefaultConditionFormatter implements ConditionFormatter {

    private final String condition;
    private final String preFormat;
    private final String postFormat;

    public DefaultConditionFormatter(String condition, String preFormat, String postFormat) {
        this.condition = condition;
        this.preFormat = preFormat;
        this.postFormat = postFormat;
    }

    @Override
    public String getCondition() {
        return condition;
    }

    @Override
    public String applyFormatTo(String text) {
        return new StringBuilder(preFormat).append(text).append(postFormat).toString();
    }

    @Override
    public boolean matches(String text) {
        return condition.equalsIgnoreCase(text);
    }

}