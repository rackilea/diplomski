String[] cmd = {"gtar", "-ztf", fileName};

// ...

// Instead of current input loop.
s = stdInput.readLine();
if(s != null) {
    sbOutput.append(s + "\n");
}

while (stdInput.readLine() != null) {
    // Disregard.  Reading to end to prevent hang.
}