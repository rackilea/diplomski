String name = fDialog.getFile();
// if Cancel is pressed we just exit
if (name == null) {
    return;
}
// otherwise we save it
fileName = name;
...