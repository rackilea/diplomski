boolean isDirectoryRelative =
    pn == 2 && isLetter(parent.charAt(0)) && parent.charAt(1) == ':';

if (child.charAt(childStart) == slash || isDirectoryRelative) {
    theChars = new char[strlen];             ^-------- this one was added from Java 9
    parent.getChars(0, parentEnd, theChars, 0);
    child.getChars(childStart, cn, theChars, parentEnd);
} else {
    theChars = new char[strlen + 1];
    parent.getChars(0, parentEnd, theChars, 0);
    theChars[parentEnd] = slash;
    child.getChars(childStart, cn, theChars, parentEnd + 1);
}