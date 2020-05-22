ASTNode ast_node = element.getNode();

if(ast_node == null) {
    return false;
}

IElementType element_type = ast_node.getElementType();

if(element_type != PhpTokenTypes.STRING_LITERAL
&& element_type != PhpTokenTypes.STRING_LITERAL_SINGLE_QUOTE) {
    return false;
}

return true;