String[] line = new String[numberOfResultpages * links.size()]; // assign adequate size to line array.

int idx = 0;
for (int i = 0; i < numberOfResultpages; i++) {

    ...
    for (Element link : links) {
       ...
       line[idx++]=title;