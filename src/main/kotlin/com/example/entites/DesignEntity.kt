package com.example.entites

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


/**
 * The Table of Designs
 */
object DesignEntity : Table<Nothing>("designs"){
    val id = int("id").primaryKey()
   val title =varchar("title")
    val category =varchar("category")
    val image =varchar("image")
    val about =varchar("about")
    val likes = int("likes")
    val size = varchar("size")
   val color = varchar("color")
}