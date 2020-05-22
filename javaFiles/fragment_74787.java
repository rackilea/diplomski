class PerformSearch extends SwingWorker<Product, Void> {
private String key = null;
public PerformSearch(String key) {
    this.key = key;
}
@Override
protected Product doInBackground() throws Exception {
    return soap.findProduct(this.key);
}
protected void done() {
    Product p = null;
    try {
         p = get();
    } catch (InterruptedException e) {
    } catch (ExecutionException e) {
    }
    prod = p;
    if (prod != null) {
        ... populate text fields
    }
    else {
        ... not found dialog
    }
}