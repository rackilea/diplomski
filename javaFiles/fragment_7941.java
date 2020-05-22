public interface OnRowInteractionListener {
    public void onRowAdded(Row row);
    public void onRowEdited(Row row);
    public void onRowRemoved(Row row);
    public void onRowActionCancel();
}