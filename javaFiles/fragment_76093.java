package za.co.thekeeper.dao;
import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import za.co.thekeeper.entities.BaseEntity;
import za.co.thekeeper.mongo.MongoConnection;
import za.co.thekeeper.mongo.MongoDbUtil;
import java.util.ArrayList;
import java.util.List;

public class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {

private JacksonDBCollection<T, String> collection;

/**Dependency Injections**/
private MongoConnection mongoConnection;

public void setMongoConnection(MongoConnection mongoConnection) {
    System.out.println("In autowired setter");
    this.mongoConnection = mongoConnection;
}

private Class<T> clazz;

public void setClazz(Class<T> clazz){
    System.out.println("In class Autowired Setter");
    this.clazz = clazz;
}

public Class<T> getClazz(){
    return clazz;
}

public BaseDAOImpl(MongoCollection mongoCollection, Class<T> clazz) {
    this.mongoCollection = mongoCollection;
    this.clazz = clazz;
    this.collection = MongoDbUtil.getCollection(mongoConnection.mongoDb(), clazz);
}
}