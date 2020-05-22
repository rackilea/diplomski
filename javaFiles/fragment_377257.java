int pos = Integer.parseInt(custom.getFriendsList());
if (pos < 0 || pos >= Constants.Friends.length) {
    // Handle the error and exit or re-read the pos
}
// Accessing Friends[pos] is safe now:
String friend = Constants.Friends[pos];