package com.example.plugins

import com.example.routes.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

/**
 * here you specify the main routing
 *
 * i set the /images as a static folder
 */
fun Application.configureRouting() {
    routing {
        root()
        getAllDesigns()
        searchDesign()
        filterDesign()
        addDesign()

        static("/images") {
            resources("images")

        }
    }
}
