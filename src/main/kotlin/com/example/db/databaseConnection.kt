package com.example.db

import org.ktorm.database.Database

/**
 * here you specify the database and the connection
 */
object databaseConnection {
    val database = Database.connect (
        url = "jdbc:mysql://localhost:3306/designme",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )
}
