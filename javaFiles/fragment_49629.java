To sum up the arguments (from the second link):

    Class.newInstance() can only invoke the zero-argument constructor, 
    while Constructor.newInstance() may invoke any constructor, regardless 
    of the number of parameters.

    Class.newInstance() throws any exception thrown by the constructor, 
    regardless of whether it is checked or unchecked. 

    Class.newInstance() requires that the constructor be visible;  
    Constructor.newInstance() may invoke private constructors under certain 
    circumstances.