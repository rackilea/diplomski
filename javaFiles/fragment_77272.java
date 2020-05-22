import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

...

Update update = new Update();
update.addToSet("posts", post);
Criteria criteria = Criteria.where("_id").is(id);
template.updateFirst(Query.query(criteria), update, "business");