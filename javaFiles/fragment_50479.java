@Override
public boolean consumes(ISemanticToken token) {
    IBinding binding = token.getBinding();
    if (binding instanceof IFunction) {
        IASTNode node = token.getNode();
        if (binding != null && node instanceof IASTName && ((IASTName) node).isReference()) {
            String n = binding.getName();
            if ("MySpecialFunction".equals(n)) {
                return true;
            }
        }
    }
    return false;
}