package apps

import com.amazonaws.services.dynamodbv2.model._
import dsl.{CredentialsProvider, DynamoDB, DynamoDBClient}

import scala.collection.JavaConversions._

object CreateTable {
  def main(args: Array[String]) = {
    createTable("test")
  }

  def createTable(name: String): Unit = {
    val dynamoDb = DynamoDB(DynamoDBClient(CredentialsProvider()))
    val attributeDefinitions = Seq(new AttributeDefinition().withAttributeName("id").withAttributeType("N"))
    val keySchema: Seq[KeySchemaElement] = Seq(new KeySchemaElement().withAttributeName("id").withKeyType(KeyType.HASH))

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
