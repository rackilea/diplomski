@InjectComponent
private Zone zone;

@InjectComponent
private Select groupSelector;

@Inject
private TypeCoercer typeCoercer;

RenderCommand onActionFromSomeComponent() {
    return new RenderCommand() {
        public void render(MarkupWriter writer, RenderQueue queue) {
            RenderCommand zoneBody = typeCoercer.coerce(zone.getBody(), RenderCommand.class);
            zoneBody.render(writer, queue);
            javaScriptSupport.addScript(
                "$('%s').observe('change', function() {" + 
                   // more stuff
                 "});",
                 groupSelector.getClientId()
            );
        }
    };
}

void afterRender() {
    javaScriptSupport.addScript(
        "$('%s').observe('change', function() {" + 
            // more stuff
        "});",
        groupSelector.getClientId()
    );
}