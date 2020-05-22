public String GetExecutable(String cmdline) {

    var executable = new StringBuilder();
    var inquote = false;

    foreach  (var c in cmdline.ToCharArray()) {
        if (c == '\"')
            inquote = !inquote;
        else if (!inquote && c == ' ')
            break;
        else
            executable.Append(c);
    }

    return executable.ToString();
}