public class VisiblityControlBehavior extends AbstractBehavior { 

    private boolean isComponentVisible() { 
        return isFormDepositoryType();
    } 

    protected boolean isFormDepositoryType() {
        return getCurrentSelections().getSelectedOwnedAccount().getAssetType() == AssetType.DEPOSITORY;
    }

    protected CurrentSelections getCurrentSelections() {
        return (CurrentSelections) getSession().getAttribute(CurrentSelections.ATTRIBUTE_NAME);
    }

    @Override 
    public void bind(Component component) { 
        boolean visible = isComponentVisible(); 
        component.setVisible(visible); 
        component.setVisibilityAllowed(visible); 
    } 
}