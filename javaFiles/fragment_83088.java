Wrapper downcast_field;
if(s instanceof A)
    downcast_field = new AWrapper( (A)s );
else if (s instanceof B)
    downcast_field = new BWrapper( (B)s );

downcast_field.foo();