android:onClick="removePayOnClickHandler"
The method body is as follows:

public void removePayOnClickHandler(View v) {
    Payment itemToRemove = (Payment)v.getTag();
    adapter.remove(itemToRemove);
}