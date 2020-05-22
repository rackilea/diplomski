import json

x = json.loads("""["[Ljava.lang.Object;",[["Object0",{"key0": null, "coolKey1": "coolValue", 
"notCoolKey2":"something"}],["Object1",{"key3": "value1", "key4": "nonCoolValue", 
"Id":"importantId0", "someId":"importantId1"}],false,["Object3", {"key6": "value6", 
"nonkey7": "supercoolValue"}]]]""")

print x[1][1][1]["Id"]
print x[1][1][1]["someId"]