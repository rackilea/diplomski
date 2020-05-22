private void updateQuestionTrue() {
    mIndex = mIndex + 1 >= mQuestionBank.length ? 0 : ++mIndex;
}

private int updateQuestionFalse() {
    return (mIndex = mIndex - 1 <= 0 ? 0 : --mIndex);
}