import sbt.Keys._

val AkkaHttpVersion = "10.2.6"

scalaVersion in ThisBuild := "2.13.6"

libraryDependencies += guice
libraryDependencies += "org.joda" % "joda-convert" % "2.2.1"
libraryDependencies += "net.logstash.logback" % "logstash-logback-encoder" % "6.6"

libraryDependencies += "net.codingwell" %% "scala-guice" % "5.0.1"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.2.6"
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.6"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.12.3"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.12.3"
libraryDependencies ++= Seq(
  jdbc,
  "org.playframework.anorm" %% "anorm" % "2.6.10"
)

maintainer := "eochieng@dynamicmobility.co.ke"

// The Play project itself
lazy val root = (project in file("."))
  .enablePlugins(Common, PlayScala)
  .settings(
    name := """ECHANNELS_ESB"""
  )
