package com.example

import com.example.db.databaseConnection
import io.ktor.application.*
import com.example.plugins.*


/**
 * the main function which uses a netty engine
 */
fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureRouting()
    configureSerialization()
    configureMonitoring()
    configureStatusPages()


}