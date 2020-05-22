if((line = r.readLine()) == "<") {
    codeBlock = true;
}
if((line = r.readLine()) == ">") {
    codeBlock = false;
}