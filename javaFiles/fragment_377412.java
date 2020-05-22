Output: Enter Character 0
> User inputs: "a\r\n" // You only entered 'a', the other two characters are from the enter key
array[0] = System.in.next(); // sets array[0] to 'a', "\r\n" are still "waiting" on the input stream

Output: Enter Character 1
> String "\r\n" is still on input, so read from those:
array[1] = System.in.next(); // sets array[1] to '\r', "\n" is still "waiting"

Output: Enter Character 2
> String "\n" is still on input, so read from that
array[2] = System.in.next(); // sets array[2] to '\n', input source is now empty

Output: Enter Character 3
> Nothing is waiting on the input stream, so program waits for user input

... and so on