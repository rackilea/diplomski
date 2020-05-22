public String getName(Object... manyVarsToCreateObjectName) {
    if (!myImportedAssumption) {
        return null;    // or anything signalling invalidity (or even throw)
    }

    if (something...) {
        return "object1";
    }

    if (something else...) {
        return "object2";
    }

    // ...

    return defaultValue;
}