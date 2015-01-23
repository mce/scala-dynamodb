
import com.amazonaws.services.dynamodbv2.document.{ DynamoDB => AmazonDynamoDB, Table }
import dsl.{DynamoDBClient, DynamoDB, CredentialsProvider}
import items.GameScore

object PutItem {
  def main(args: Array[String]): Unit = {
    val dynamoDb = DynamoDB(DynamoDBClient(CredentialsProvider()))
    val table = dynamoDb.getTable("test")
    putItem(dynamoDb, table, GameScore(1, "Angry Birds", 321))
  }

  def putItem(dynamoDB: AmazonDynamoDB, table: Table, score: GameScore) = {
    val item = GameScore.toItem(score)
    table.putItem(item)
  }
}