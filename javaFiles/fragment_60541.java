BOOL WINAPI CryptUnprotectData(
  _In_        DATA_BLOB *pDataIn,
  _Out_opt_   LPWSTR *ppszDataDescr,
  _In_opt_    DATA_BLOB *pOptionalEntropy,
  _Reserved_  PVOID pvReserved,
  _In_opt_    CRYPTPROTECT_PROMPTSTRUCT *pPromptStruct,
  _In_        DWORD dwFlags,
  _Out_       DATA_BLOB *pDataOut
);