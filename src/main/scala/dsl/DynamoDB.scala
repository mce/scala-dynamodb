package dsl

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.document.DynamoDB

object DynamoDB {
  def apply(client: AmazonDynamoDBClient) = new DynamoDB(client)

}
