int utf8_length;

wchar_t* utf16 = ...;

utf8_length = WideCharToMultiByte(
  CP_UTF8,           // Convert to UTF-8
  0,                 // No special character conversions required 
                     // (UTF-16 and UTF-8 support the same characters)
  utf16,             // UTF-16 string to convert
  -1,                // utf16 is NULL terminated (if not, use length)
  NULL,              // Determining correct output buffer size
  0,                 // Determining correct output buffer size
  NULL,              // Must be NULL for CP_UTF8
  NULL);             // Must be NULL for CP_UTF8

if (utf8_length == 0) {
  // Error - call GetLastError for details
}

char* utf8 = ...; // Allocate space for UTF-8 string

utf8_length = WideCharToMultiByte(
  CP_UTF8,           // Convert to UTF-8
  0,                 // No special character conversions required 
                     // (UTF-16 and UTF-8 support the same characters)
  utf16,             // UTF-16 string to convert
  -1,                // utf16 is NULL terminated (if not, use length)
  utf8,              // UTF-8 output buffer
  utf8_length,       // UTF-8 output buffer size
  NULL,              // Must be NULL for CP_UTF8
  NULL);             // Must be NULL for CP_UTF8

if (utf8_length == 0) {
  // Error - call GetLastError for details
}