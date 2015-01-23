package dsl

import com.amazonaws.auth.profile.ProfileCredentialsProvider

object CredentialsProvider {
  def apply() = new ProfileCredentialsProvider()
  def apply(profileName: String) = new ProfileCredentialsProvider(profileName)
  def apply(filePath: String, profileName: String) = new ProfileCredentialsProvider(filePath, profileName)
}
