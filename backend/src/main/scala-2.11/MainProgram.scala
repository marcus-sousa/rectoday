import com.mongodb.spark.MongoSpark
import factory._
/**
  * @author marcussousa
  * @since 11/15/16.
  */
object MainProgram extends App {

  val ss = new SparkSessionFactory().newSparkSession()
  val df = MongoSpark.load(ss)
  val column = df.show(1)
  ss.stop()
}
