package dsl

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.document.{ DynamoDB => AmazonDynamoDB }

object DynamoDB {
  def apply(client: AmazonDynamoDBClient) = new AmazonDynamoDB(client)
}
