name := "gode-sunder-model"

version := "0.1.0-SNAPSHOT"

organization := "com.github.ScalABM"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  "Typesafe Repo" at "https://repo.typesafe.com/typesafe/releases/",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "com.typesafe.akka" %% "akka-slf4j" % "2.4.1",
  "com.typesafe.play" %% "play-json" % "2.5.0",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "com.github.ScalABM" %% "markets-sandbox" % "0.1.0-alpha-SNAPSHOT"
)

fork in run := true

javaOptions ++= Seq(
  //"-Xmn3G",
  //"-Xmx2G",
  //"-XX:+UseG1GC",
  //"-XX:+UseNUMA",
  //"-XX:+UseCondCardMark",
  //"-XX:-UseBiasedLocking",
  "-XX:+PrintCommandLineFlags"
  //"-XX:+PrintGCDetails",
  //"-XX:+PrintGCTimeStamps"
)
