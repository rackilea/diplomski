const char *ATCommands[] = { "CGMI", "CGMM" };

char bufferTX[128];
int command_len= 0;

command_len = sprintf(bufferTX, "AT+%s", ATCommand[commandToSend]);

if (command_len > 3)
{
   UART_send(bufferTX, command_len);
}