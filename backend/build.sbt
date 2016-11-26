name := "backend"

version := "1.0"

scalaVersion := "2.11.8"
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.0.2"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.2"
libraryDependencies += "org.mongodb.spark" % "mongo-spark-connector_2.11" % "2.0.0"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"

