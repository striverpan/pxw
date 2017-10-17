package com.pan.tool.app

import com.pan.tool.util.{HiveUtil, MySQLUtil}
import java.util
import scala.collection.JavaConversions._


/**
  * Created by pan on 2017/7/6.
  */
object App {

    def main(args: Array[String]): Unit = {

   /*     val mysqlUtil = new MySQLUtil()
        val hiveUtil = new HiveUtil()
        val tableNames: util.ArrayList[String] = mysqlUtil.select("select table_name from ht_label_table");

        for (tableName:String <- tableNames){
            val sql:String = "alter table ana_crmpicture."+tableName+" drop if exists partition(dt<"+args(1)+");"
            hiveUtil.DDL(sql)
        }*/
    }

}
