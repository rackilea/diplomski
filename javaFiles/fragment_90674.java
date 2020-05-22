public boolean isChecked(int position) {
        return mCheckStates.get(position, false);
    }

    public void setChecked(int position, boolean isChecked) {
        mCheckStates.put(position, isChecked);

    }

    public void toggle(int position) {
        setChecked(position, !isChecked(position));
    }
@Override
public void onCheckedChanged(CompoundButton buttonView,
        boolean isChecked) {
     mCheckStates.put((Integer) buttonView.getTag(), isChecked);    

}