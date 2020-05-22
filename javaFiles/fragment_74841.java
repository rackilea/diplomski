@Override
 public void onNotifyCallback(ObservableList.OnListChangedCallback callback,
            ObservableList sender, int notificationType, ListChanges listChanges) {
        switch (notificationType) {
            case CHANGED:
                callback.onItemRangeChanged(sender, listChanges.start, listChanges.count);
                break;
            //more cases
        }
}