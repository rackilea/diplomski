if (_imagesPath == null) {
    for (int i = 0; i <= 1; i++) {
        _imagesPath[i] = _userImagePath[i];
        _originalBitmaps[i] = BitmapFactory.decodeFile(_imagesPath[i]);
    }
}