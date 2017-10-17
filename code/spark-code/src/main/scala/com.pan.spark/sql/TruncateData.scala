package com.pan.spark.sql

import java.util.Properties

import org.apache.hadoop.hive.ql.parse.SemanticException
import org.apache.spark.sql.execution.QueryExecutionException
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by pan on 2017/7/6.
  */
object TruncateData {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("truncate-data")
    val sc = new SparkContext(conf)
    val hiveContext = new HiveContext(sc)
    val properties = new Properties()
    properties.put("user", "crmyuntu")
    properties.put("password", "crmpasswd")
    properties.put("driver", "com.mysql.jdbc.Driver")
    val url = "jdbc:mysql://168.6.1.29:8177/crmyuntu?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=convertToNull"
    val jdbcDF = hiveContext.read.jdbc(url, "ht_label_table", properties)
    val tables: Array[String] = jdbcDF.select("table_name").map(row => row.get(0).toString).collect()

    for (tableName <- tables) {
      try {
        val s = "alter table ana_crmpicture." + tableName + " drop if exists partition(dt<" + args(0) + ")"
        hiveContext.sql(s)
      } catch {
        case ex: SemanticException => System.err.print("---------------Exception");
        case ex: QueryExecutionException => System.err.print("---------------Exception");
      }
    }
    hiveContext.sql("use ana_crmpicture")
    val dbDF: DataFrame = hiveContext.sql("show tables")
    val hiveTables: Array[Row] = dbDF.filter(dbDF("tableName") like ("ds_t_s1%") or (dbDF("tableName") like ("ds_t_s2%"))).collect()
    for (hiveTable <- hiveTables) {
        try {
          val s = "alter table ana_crmpicture." + hiveTable.get(0).toString + " drop if exists partition(dt<" + args(0) + ")"

          hiveContext.sql(s)
        } catch {
          case ex: SemanticException => System.err.print("---------------Exception");
          case ex: QueryExecutionException => System.err.print("---------------Exception");
        }
    }
    sc.stop()
  }
}
