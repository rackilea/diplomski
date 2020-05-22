Sets the operation that will happen by default when the user initiates a "close" on this frame. You must specify one of the following choices:

- DO_NOTHING_ON_CLOSE (defined in WindowConstants): Don't do anything; require the program to handle the operation in the windowClosing method of a registered WindowListener object.
- HIDE_ON_CLOSE (defined in WindowConstants): Automatically hide the frame after invoking any registered WindowListener objects.
- DISPOSE_ON_CLOSE (defined in WindowConstants): Automatically hide and dispose the frame after invoking any registered WindowListener objects.
- EXIT_ON_CLOSE (defined in JFrame): Exit the application using the System exit method. Use this only in applications.