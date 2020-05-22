public class WriteCommand
{
public void send(String command)
{
    txtA.append("Command:>>"+ command + "\n");
    writer.write(command);
    writer.write("\n");
    writer.flush(); 
}
}