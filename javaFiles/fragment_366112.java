import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.GetItemOutcome;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
//import com.amazonaws.services.dynamodbv2.document.Table;

com.amazonaws.services.dynamodbv2.document.Table highScoreTable;

void settings() {
  size(640, 480);
}

void setup() {
  DynamoDB dynamoDB = new DynamoDB(
        AmazonDynamoDBClientBuilder
            .standard()
            .withRegion(Regions.EU_NORTH_1)
            .build()
  );

  highScoreTable = dynamoDB.getTable("stackoverflow-q60122736");

  noLoop();
}

void draw() {
  PrimaryKey primaryKey = new PrimaryKey("id", "player-007");
  GetItemOutcome outcome = highScoreTable.getItemOutcome(primaryKey);
  String highScore = outcome.getItem().getString("high-score");

  fill(0);
  text("Hi AWS DynamoDB! The high score is " + highScore + ".", 10, 20);
}