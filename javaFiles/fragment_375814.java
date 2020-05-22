invoke-virtual {v0}, Lcom/myapp/data/weblink;->getLink()Ljava/lang/String;

move-result-object v0

invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

move-result-object v0

# Add following line to override v0 before it's appended to the StringBuilder
const-string v0, "www.google.com"

invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;