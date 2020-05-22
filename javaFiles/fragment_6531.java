gcLogFileStream::gcLogFileStream(const char* file_name) {
  _cur_file_num = 0;
  _bytes_written = 0L;
  _file_name = make_log_name(file_name, NULL);

  // gc log file rotation
  if (UseGCLogFileRotation && NumberOfGCLogFiles > 1) {
    char tempbuf[FILENAMEBUFLEN];
    jio_snprintf(tempbuf, sizeof(tempbuf), "%s.%d" CURRENTAPPX, _file_name, _cur_file_num);
    _file = fopen(tempbuf, "w");
  } else {
    _file = fopen(_file_name, "w");
  }
  if (_file != NULL) {
    _need_close = true;
    dump_loggc_header();
  } else {
    warning("Cannot open file %s due to %s\n", _file_name, strerror(errno));
    _need_close = false;
  }
}

void gcLogFileStream::write(const char* s, size_t len) {
  if (_file != NULL) {
    size_t count = fwrite(s, 1, len, _file);
    _bytes_written += count;
  }
  update_position(s, len);
}