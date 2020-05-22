@Override
protected TemplateModel handleUnknownType(Object obj) throws TemplateModelException {
    if (obj instanceof Color) {
        return new SimpleScalar(toHTMLHexCode((Color) obj));
    }
    return super.handleUnknownType(obj);
}