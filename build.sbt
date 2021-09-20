import sbt.Keys._

lazy val GatlingTest = config("gatling") extend Test

// This must be set to 2.11.11 because Gatling does not run on 2.12.2
scalaVersion in ThisBuild := "2.11.11"

libraryDependencies += guice
libraryDependencies += "org.joda" % "joda-convert" % "1.8"
libraryDependencies += "net.logstash.logback" % "logstash-logback-encoder" % "4.9"

libraryDependencies += "com.netaporter" %% "scala-uri" % "0.4.16"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0-M3" % Test
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.2" % Test
libraryDependencies += "io.gatling" % "gatling-test-framework" % "2.2.2" % Test
// https://mvnrepository.com/artifact/com.typesafe.akka/akka-http
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.11"
// https://mvnrepository.com/artifact/com.typesafe.akka/akka-http-spray-json
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10"
//libraryDependencies += javaJdbc
// https://mvnrepository.com/artifact/com.microsoft.sqlserver/mssql-jdbc
//libraryDependencies += "com.microsoft.sqlserver" % "mssql-jdbc" % "6.2.2.jre8" % Test
// https://mvnrepository.com/artifact/com.microsoft.sqlserver/sqljdbc4
//libraryDependencies += "com.microsoft.sqlserver" % "sqljdbc4" % "4.0" % Test
libraryDependencies ++= Seq(
  jdbc,
  //"com.microsoft.sqlserver" % "mssql-jdbc" % "6.2.2.jre8" % Test ,
  "mysql" % "mysql-connector-java" % "5.1.41",
  "com.typesafe.play" %% "anorm" % "2.5.1"
)

// The Play project itself
lazy val root = (project in file("."))

  .enablePlugins(Common, PlayScala, GatlingPlugin)
  .configs(GatlingTest)
  .settings(inConfig(GatlingTest)(Defaults.testSettings): _*)
  .settings(
    name := """ECHANNELS_ESB""",
    scalaSource in GatlingTest := baseDirectory.value / "/gatling/simulation"
  )

// Documentation for this project:
//    sbt "project docs" "~ paradox"
//    open docs/target/paradox/site/index.html
/*
lazy val docs = (project in file("docs")).enablePlugins(ParadoxPlugin).
  settings(
    paradoxProperties += ("download_url" -> "https://example.lightbend.com/v1/download/play-rest-api")
  )
  */
