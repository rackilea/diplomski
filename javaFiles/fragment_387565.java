static final String A_COMMAND_PREFIX = "RM20 A ";

.
.
.

if (fromServer.startsWith(A_COMMAND_PREFIX)) {
  // Process user input
  final String userInput = fromServer.substring(A_COMMAND_PREFIX.length());

} else if (fromServer.equals("RM20 B")) {
  // Process B command
} else if (fromServer.equals("RM20 L")) {
  // Process L command
} else if (fromServer.equals("RM20 I")) {
  // Process I command
} else if (fromServer.equals("RM20 C")) {
  // Process C command
} else {
  // Handle unknown command
}