apktool.bat d -r -f -o .\disassembled "app-debug.apk"

.method public setVoice21(Ljava/lang/String;Ljava/lang/String;)I
.prologue
:try_start_0
new-instance v1, Ljava/util/Locale$Builder;
invoke-direct {v1}, Ljava/util/Locale$Builder;-><init>()V
...
:try_end_0
.catch Ljava/util/IllformedLocaleException; {:try_start_0 .. :try_end_0} :catch_0
...
:catch_0
move-exception v0
.local v0, "ex":Ljava/util/IllformedLocaleException;
invoke-virtual {v0}, Ljava/util/IllformedLocaleException;->printStackTrace()V