0: getstatic       #42             // ClassUnderTest.$jacocoData : [Z
 3: dup
 4: ifnonnull       22
 7: pop
 9: ldc2_w          #43             // long -1475355800743669619l
11: ldc             #44             // String ClassUnderTest
13: bipush          64
15: invokestatic    #45             // org/jacoco/agent/rt/internal_1f1cc91/Offline."getProbes":(JLjava/lang/String;I)[Z
18: dup
19: putstatic       #42             // ClassUnderTest.$jacocoData : [Z