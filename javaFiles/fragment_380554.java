public class ExamplePanel extends Widget
{
    private static ExamplePanelUiBinder uiBinder = GWT.create(ExamplePanelUiBinder.class);

    interface ExamplePanelUiBinder extends UiBinder<Element, ExamplePanel>
    {
    }

    @UiField LabelElement inputLabel;

    public ExamplePanel()
    {
        setElement(uiBinder.createAndBindUi(this));
    }
}

<ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder">
    <label ui:field="inputLabel">Label text</label>
</ui:UiBinder>