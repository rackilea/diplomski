if (cmd.indexOf("cd ") >= 0)
{
    String req_cmd = cmd.substring(0, 3);
    String req_path = cmd.substring(3);
    if (req_path.startsWith(File.separator) || req_path.substring(1, 2).equals(":"))
        path = req_path;
    else
        if (new File(path + cmd.substring(3)).exists())
            path += cmd.substring(3);
        else return "[Error] Directory doesn't exist.\n";

    if (!path.endsWith(File.separator)) path += File.separator;

    cmd = req_cmd + path;
}
else cmd = "cd " + path + " & " + cmd;