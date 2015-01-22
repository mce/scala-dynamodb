import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.model._

import scala.collection.JavaConversions._

object CreateTable {
  def main(args: Array[String]) = {
    createTable("test")
  }

  def createTable(name: String): Unit = {
    val dynamoDb = new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()))
    val attributeDefinitions = Seq.empty[AttributeDefinition]
    val keySchema: Seq[KeySchemaElement] = Seq(new KeySchemaElement().withAttributeName("Id").withKeyType(KeyType.HASH))

    val request = new CreateTableRequest()
      .withTableName(name)
      .withKeySchema(keySchema)
      .withAttributeDefinitions(attributeDefinitions)
      .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(5L).withWriteCapacityUnits(6L))

    val table = dynamoDb.createTable(request)

    val description = dynamoDb.getTable(name).describe()

    printf("%s: %s \t ReadCapacityUnits: %d \t WriteCapacityUnits: %d",
      description.getTableStatus,
      description.getTableName,
      description.getProvisionedThroughput().getReadCapacityUnits(),
      description.getProvisionedThroughput().getWriteCapacityUnits())
  }
}
