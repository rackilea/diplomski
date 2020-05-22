void TestVoid(void)
{
    wchar_t                     wcBuffer[2600]      = {};
    size_t                      szOut               = 0;
    std::string                 Path                = "This message for test WCHAR.";
    errno_t                     errCode             = 0;

    // Work:
    errCode = mbstowcs_s(&szOut, wcBuffer, sizeof(wcBuffer), (char*)Path.c_str(), Path.size());
    // Not work:
    errCode = mbstowcs_s(&szOut, wcBuffer, Path.size(), (char*)Path.c_str(), Path.size()); 
}