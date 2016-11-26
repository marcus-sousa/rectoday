package factory

import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.SparkSession

/**
  * @author marcussousa.
  * @since 11/26/16.
  */
class SparkSessionFactory {

  val conf = ConfigFactory.load("database")

  def newSparkSession(): SparkSession = {

    val ss = SparkSession.builder()
      .config("spark.mongodb.input.database", conf.getString("mongodb.database"))
      .config("spark.mongodb.input.collection", conf.getString("mongodb.collection"))
      .config("spark.mongodb.input.uri", conf.getString("mongodb.uri"))
      .master("local")
      .appName("rectoday")
      .getOrCreate()

       ss
  }
}
