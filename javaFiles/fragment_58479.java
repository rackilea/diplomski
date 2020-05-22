[...]
boolean isSnapshot1 = str1.endsWith("SNAPSHOT");
boolean isSnapshot2 = str2.endsWith("SNAPSHOT");
[...]
if (...) { // if version-number are equal
    if (isSnapshot1 && !isSnapshot2) { // same versions, but first is snapshot
        return (1);
    }
    if { // same versions, but secont is snapshot
        return (-1);
    }
    // else { Neither or both are snapshots, versions are equals -> cannot distinguish their order
        return (0);
    // }
}
[...]