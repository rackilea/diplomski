const jchar* raw = env->GetStringChars(string, NULL);
if (raw == NULL)
    return NULL;

wchar_t* wsz = new wchar_t[len+1];
memcpy(wsz, raw, len*2);
wsz[len] = 0;

env->ReleaseStringChars(string, raw);

return wsz;