int32_t tlength;
std::string utf8Bytes;
//load the tlength as a 32 bit integer, then the utf8 bytes from the file
//well, that's easy for UTF8

//to turn that into a utf-18 string in windows
int wlength = MultiByteToWideChar(CP_UTF8, 0, utf8Bytes.c_str(), utf8Bytes.size(), nullptr, 0);
std::wstring result(wlength, '\0');
MultiByteToWideChar(CP_UTF8, 0, utf8Bytes.c_str(), utf8Bytes.size(), &result[0], wlength);
//so that's not hard either