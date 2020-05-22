package q41323887;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

final class FormulaDefinition {

    @SerializedName("count")
    @Expose
    private /*final*/ int count /*= 0*/; // Gson works with final primitives like `int` strangely

    @SerializedName("operatorDefinitions")
    @Expose
    private final List<OperatorDefinition> operatorDefinitions = null;

    private FormulaDefinition() {
    }

    @Override
    public String toString() {
        return new StringBuilder("FormulaDefinition{")
                .append("count=").append(count)
                .append(", operatorDefinitions=").append(operatorDefinitions)
                .append('}')
                .toString();
    }

}