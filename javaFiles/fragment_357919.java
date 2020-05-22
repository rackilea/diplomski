Foundation.log("titleLabel.text: " + button.getKeyValueCoder().getValue("titleLabel.text"));

button.addKeyValueObserver("titleLabel.text", new NSKeyValueObserver() {
    @Override
    public void observeValue(String keyPath, NSObject object, NSKeyValueChangeInfo change) {
        Foundation.log(keyPath + " " + object + " " + change);
    }
});