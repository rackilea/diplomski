btn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
    // first val in List is incremented but onChanged isn't called, why?
    List<Integer> temp = vals.getValue();
    if(temp!=null) // null-safety just in case....
    {
        int newVal = temp.get(0) + 1;
        temp.set(0, newVal);
        vals.setValue(temp);
        Log.d(TAG, "set val at index 0 to " + newVal);
    }
}
});