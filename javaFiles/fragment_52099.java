private MMenuItem menuItem;
private MToolItem toolItem;

@PostConstruct
protected void initControls(MApplication app) {
    setToolItem((MToolItem) modelService.find("tool.item.id", app));
}