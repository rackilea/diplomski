chanItem.setEndElementListener(new EndElementListener()  {
    public void end() {
        _items.add(_item);
        if (++_currentItem == _maxElements) {
            throw new SaxBreakOutException();
        }
    }
});