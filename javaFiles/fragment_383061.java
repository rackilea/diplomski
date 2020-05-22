@Override
public void append(int key, E value) {
    if (mLocked)
        return; // Maybe throw an exception
    super.append(key, value);
}