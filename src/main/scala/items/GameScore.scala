package items

import com.amazonaws.services.dynamodbv2.document.Item

case class GameScore(userId: Int, game: String, score: Long)

object GameScore {
  def toItem(gameScore: GameScore) = new Item()
    .withPrimaryKey("id", gameScore.userId)
    .withNumber("score", gameScore.score)
    .withString("game", gameScore.game)
}