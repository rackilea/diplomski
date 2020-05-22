[System.Security.SecurityCritical]  // auto-generated
    unsafe string InternalSubString(int startIndex, int length) {
        Contract.Assert( startIndex >= 0 && startIndex <= this.Length, "StartIndex is out of range!");
        Contract.Assert( length >= 0 && startIndex <= this.Length - length, "length is out of range!");            

        String result = FastAllocateString(length);

        fixed(char* dest = &result.m_firstChar)
            fixed(char* src = &this.m_firstChar) {
                wstrcpy(dest, src + startIndex, length);
            }

        return result;