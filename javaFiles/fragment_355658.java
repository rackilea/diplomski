for(string user: users)
{
  if(hashmap.contains(user))
    {
       HashSet<Sting> usergroups = hashmap.get(user);
       usergroups.add(group);
    }
   else
    {
      HashSet<String> groups = new HashSet<String> ();
       groups.add(group);
    }
}