package dsl

import com.amazonaws.auth.{AWSCredentialsProvider, AWSCredentials}
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient

object AmazonDynamoDBClient {
  def apply() = new AmazonDynamoDBClient()
  def apply(credentials: AWSCredentials) = new AmazonDynamoDBClient(credentials)
  def apply(credentialsProvider: AWSCredentialsProvider) = new AmazonDynamoDBClient(credentialsProvider)
}
