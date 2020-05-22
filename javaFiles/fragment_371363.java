private void updateQuestionTrue() {
    if(mIndex + 1 >= mQuestionBank.length) {
        mIndex = 0;
    }
    else
        mIndex++;
}

private int updateQuestionFalse() {
    if(mIndex - 1 <= 0) {
      //mIndex = mQuestionBank.length - 1; //too loop back around
      mIndex = 0; //or to keep the index at 0 once you are as far back as possible
    }
    else
        mIndex--;

    return mIndex;
}