package com.pan.tool.util


import java.sql.{Connection, DriverManager, ResultSet, Statement}
import java.util

/**
  * Created by pan on 2017/7/5.
  */
class MySQLUtil {


    def getConnection(): Connection = {
        val db = "jdbc:mysql://168.6.2.27:3306/ht_market?user=crmyuntu&password=crmpasswd"
        classOf[com.mysql.jdbc.Driver]
        val con = DriverManager.getConnection(db)
        return con
    }

    def insert(sql: String): Unit = {
        val con = getConnection()
        val st = con.createStatement()
        st.executeUpdate(sql)
        close(st,con)
    }

    def select(sql: String): util.ArrayList[String] = {
        val con = getConnection()
        val st: Statement = con.createStatement()
        val resSet: ResultSet = st.executeQuery(sql)
        val resList = new util.ArrayList[String]()
        while (resSet.next()) {
            val res = resSet.getString("table_name")
            resList.add(res)
        }
        close(st,con)
        return resList
    }

    def close(st: Statement, con: Connection): Unit = {
        st.close()
        con.close()
    }

}
