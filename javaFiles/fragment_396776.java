public void applySelectedValue() {
  helper(mThingy, mBox.getSelectedIndex());
}

private static <T> void helper(GenericThingy<T> pThingy, int pIndex) {
  pThingy.setValue(pThingy.mCandidates[pIndex]);
}