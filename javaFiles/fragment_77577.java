for (int y = 0; y < eye.rows; y++)
{
    uchar *ptr = eye.ptr<uchar>(y);
    for (int x = 0; x < eye.cols; x++)
    {
      int value = static_cast<int>(*ptr);
      // A loop not using ptr.
      ++ptr;
    }
}