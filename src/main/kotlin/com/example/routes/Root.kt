package com.example.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

/**
 * just a get request to check if the server is working
 */
fun Route.root() {
    get("/"){
        call.respond(
            message = "Welcome to My Design API!",
            status = HttpStatusCode.OK
        )
    }
}