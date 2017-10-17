package com.pan.util

import java.io.File

import scala.io.Source

/**
  * Created by pan on 2017/8/24.
  */
object FileOperate {

  def main(args: Array[String]): Unit = {

    val path = this.getClass.getClassLoader.getResource("etl_ms_cust_zl_pkg").getPath
    val file = new File(path)

    file.listFiles.foreach(file => {
      if (file.isFile) {
        println(file.getAbsolutePath)
        val source = Source.fromFile(file,"UTF-8").mkString
        println(source)
      }
    })
  }

}
