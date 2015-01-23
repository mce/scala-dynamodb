import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.document.{Item, DynamoDB, Table}

case class GameScore(userId: Int, game: String, score: Long)

object PutItem {
  def main(args: Array[String]): Unit = {
    val dynamoDb = new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()))
    val table = dynamoDb.getTable("test")

    putItem(dynamoDb, table, GameScore(1, "Angry Birds", 321))
  }

  def putItem(dynamoDB: DynamoDB, table: Table, score: GameScore) = {
    val item = new Item()
      .withPrimaryKey("id", score.userId)
      .withNumber("score", score.score)
      .withString("game", score.game)

    table.putItem(item)
  }
}