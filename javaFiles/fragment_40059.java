@Override
    protected String getPassword(String username)
    {
        if(username.equals(_firstUser))
            return _firstUserPassword;
        else if(username.equals(_secondUser))
            return _secondUserPassword;
        //etc with your other users
    }

    @Override
    protected Principal getPrincipal(String username)
    {
        if(username.equals(_firstUser))
        {
            return new GenericPrincipal(username, _firstUserPassword, _roles);
        }
        else if(username.equals(_secondUser)
        {
            return new GenericPrincipal(username, _secondUserPassword, _roles);
        }
        //etc with your other users
    }