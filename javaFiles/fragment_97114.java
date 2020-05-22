/**
     * Indicate the element has dynamic values and thus cannot be drawn in bulk
     * operations. Called by the GraphicElement.
     * 
     * @param element
     *            The element.
     */
    protected void pushElementAsDynamic(Element element) {
        if (dynamicOnes == null)
            dynamicOnes = new HashSet<Element>();

        dynamicOnes.add(element);
    }

    /**
     * Indicate the element has no more dynamic values and can be drawn in bulk
     * operations. Called by the GraphicElement.
     * 
     * @param element
     *            The element.
     */
    protected void popElementAsDynamic(Element element) {
        dynamicOnes.remove(element);

        if (dynamicOnes.isEmpty())
            dynamicOnes = null;
    }