import net.sourceforge.pmd.AbstractJavaRule;
import net.sourceforge.pmd.ast.ASTCastExpression;

public class CastRule extends AbstractJavaRule {

    public CastRule() {
    }

    @Override
    public Object visit(final ASTCastExpression node, final Object data) {
        addViolation(data, node);
        return super.visit(node, data);
    }
}