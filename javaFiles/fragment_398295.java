// creates a new instance of the DefaultTableModel class and assigns it
// to a previously declared variable named _model.
// Note that contrary to C++, starting a variable name with an underscore is
// legal but discouraged as a convention in Java
// (http://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
_model = new DefaultTableModel(

    // this is first parameter to the DefaultTableModel constructor taking
    // a two-dimensional array of Objects as the first parameter, and an
    // array of Objects as the second. This creates an empty 2D array.
    new Object [][] {
    },

    // this is the second parameter to the DefaultTableModel constructor.
    // It creates an array of Strings initialized with the provided values
    new String [] {
        "Id", "Project Title", "Start Date", "Deadline", "Description", "PercentDone"
    })

        // start of the redifinition of the DefaultTableModel class
        {

            // creates a member variable named types at the default visibility.
            // This member is an array of Class objects, initialized with the
            // provided values
            Class[] types = new Class [] 
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            // creates a member variable named canEdit at the default visibility.
            // This member is an array of booleans, all initialized to false.
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            // annotation used by IDEs and the compiler specifying that the
            // method that follows overrides a method in the DefaultTableModel
            // class. If the methods does not actually override such a method,
            // an error will be generated (e.g. due to a spelling mistake in the
            // method name or the wrong parameters being declared)
            @Override

            // override of the default getColumnClass method
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            // see explanation above
            @Override

            // override of the default isCellEditable method
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

    // end of the anonymous class
    };
// end of the constructor call and assignment to _model statement.
);