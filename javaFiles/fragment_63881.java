String userid = username;

if( username.contains( "#" ) )
{
    ip = username.split( "#" )[0];
    userid = username.split( "#" )[1];
}