void startElement(...) {
    if (name.equals("element1")) {
        inElement1 = true;
        element1Content = new StringBuffer();
    }
}

void characters(...) {
    if (inElement1) {
        element1Content.append(characterData);
    }
}

void endElement(...) {
    if (name.equals("element2")) {
        inElement1 = false;
        processElement1Content(element1Content.toString());
    }
}