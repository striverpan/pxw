package com.pan.tool.util

import java.sql.{Connection, DriverManager, ResultSet, Statement}
import java.util

/**
  * Created by pan on 2017/7/5.
  * 不好直接运行
  */
class HiveUtil {


    def getConnection(): Connection = {
        val driverName = "org.apache.hadoop.hive.jdbc.HiveDriver"
        Class.forName(driverName)
        val url = "jdbc:hive://168.6.2.26:10000/ana_crmpicture"
        val con = DriverManager.getConnection(url, "hue", "hue")
        return con
    }


    def insert(sql: String): Unit = {
        val con = getConnection()
        val st = con.createStatement()
        st.executeUpdate(sql)
        close(st, con)
    }

    def select(sql: String): util.ArrayList[String] = {
        val con = getConnection()
        val st = con.createStatement()
        val resSet: ResultSet = st.executeQuery(sql)
        val resList = new util.ArrayList[String]()
        while (resSet.next()) {
            val res = resSet.getString("table_name")
            resList.add(res)
        }
        close(st, con)
        return resList
    }

    def DDL(sql: String): Unit = {
        val con = getConnection()
        val st = con.createStatement()
        st.execute(sql)
        close(st, con)
    }

    def close(st: Statement, con: Connection): Unit = {
        st.close()
        con.close()
    }

}
