class College implements Serializable
{
    String name
    String description
    boolean update

    transients = ['update']

    def beforeUpdate()
    {
       if(!this.update)
          return false
    }}