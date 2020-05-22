// Disregards strings with variables, concatenation, etc.
if (element.getPrevSibling() != null || element.getNextSibling() != null) {
    return false;
}

return true;