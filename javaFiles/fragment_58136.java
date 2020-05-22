@XmlElements({
    @XmlElement(name = "block-container", required = true, type = BlockContainer.class),
    @XmlElement(name = "retrieve-marker", required = true, type = RetrieveMarker.class),
    @XmlElement(name = "list-block", required = true, type = ListBlock.class),
    @XmlElement(name = "table", required = true, type = Table.class),
    @XmlElement(name = "float", required = true, type = Float.class),
    @XmlElement(name = "multi-properties", required = true, type = MultiProperties.class),
    @XmlElement(name = "table-and-caption", required = true, type = TableAndCaption.class),
    @XmlElement(name = "footnote", required = true, type = Footnote.class),
    @XmlElement(name = "marker", required = true, type = Marker.class),
    @XmlElement(name = "multi-switch", required = true, type = MultiSwitch.class),
    @XmlElement(name = "block", required = true, type = Block.class),
    @XmlElement(name = "wrapper", required = true, type = Wrapper.class)
})
protected List<Object> markerOrBlockOrBlockContainer;