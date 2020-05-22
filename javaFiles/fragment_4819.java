//array to hold replacements
String[][] replacements = {{"foo", "foo2"}, 
                           {"bar", "bar2"}};

//loop over the array and replace
for(String[] replacement: replacements) {
    src = src.replace(replacement[0], replacement[1]);
}