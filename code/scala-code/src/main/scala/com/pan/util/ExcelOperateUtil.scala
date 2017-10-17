
package com.pan.util

import java.io.{File, FileInputStream}

import com.pan.entity.JXLEntity
import jxl.Workbook
import org.apache.log4j.Logger
import org.apache.log4j.spi.LoggerFactory
import org.slf4j.LoggerFactory

import scala.io.Source

/**
  * Created by pan on 2017/8/23.
  */
object ExcelOperateUtil {


  def main(args: Array[String]): Unit = {


    //创建输入流
    val stream = new FileInputStream(ExcelOperateUtil.getClass.getClassLoader.getResource("tableindex.xls").getPath)
    //获取Excel文件对象
    val rwb = Workbook.getWorkbook(stream)
    //获取文件的指定工作表 默认的第一个
    val sheet = rwb.getSheet(0)
    for (i <- 1 until sheet.getRows) {
      val cell1 = sheet.getCell(0, i).getContents
      val cell2 = sheet.getCell(2, i).getContents
      val cell3 = sheet.getCell(12, i).getContents

    }
    stream.close()


  }
}
