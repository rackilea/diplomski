// Create TestNull object
3: new             #3; //class TestNull
6: dup
7: invokespecial   #4; //Method TestNull."<init>":()V

// Invoke the temp method
10: invokevirtual   #5; //Method TestNull.temp:()LTestNull;

// Discard the result of the call to temp.
13: pop

// Load the content of the static field.
14: getstatic       #6; //Field TestNull.field:I