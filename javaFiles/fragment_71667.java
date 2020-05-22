jclass mpclass = jenv->FindClass("NS/ManagementProcessor");
jobject jmp = 0;
jmethodID mpid;
ManagementProcessorPtr *realm = new ManagementProcessorPtr(e.getRealm());
jlong jrealm;
*(ManagementProcessorPtr **)&jrealm = realm;
mpid = jenv->GetMethodID(mpclass, "<init>", "(JZ)V");
jmp = jenv->NewObject(mpclass, mpid, jrealm, true);