import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.ArrayOperators.arrayOf;

Aggregation agg = newAggregation(
 lookup("images", "imageId", "_id", "image"), 
 unwind("image"), 
 project("text").and(arrayOf("image.likers").containsValue("2")).as("liked")
);