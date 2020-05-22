import java.util.Collection;
import java.util.ArrayList;

Rule "Example Rule"
  when
    # Your condition
  then
    Collection collection = new ArrayList();
    # add what ever you want into the collection
    insert( collection );
end