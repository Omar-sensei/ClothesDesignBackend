package com.example.routes

import com.example.db.databaseConnection
import com.example.entites.DesignEntity
import com.example.models.ApiResponse

import com.example.models.Design
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select

/**
 * GET : to fetch all Designs from the database
 */
fun Route.getAllDesigns() {
    val db = databaseConnection.database


    get("/designs") {
        val designs = db.from(DesignEntity).select().map {
            val id = it[DesignEntity.id]
            val title = it[DesignEntity.title]
            val category = it[DesignEntity.category]
            val image = it[DesignEntity.image]
            val about = it[DesignEntity.about]
            val likes = it[DesignEntity.likes]
            val size = it[DesignEntity.size]
            val color = it[DesignEntity.color]
            Design(
                id ?: -1,
                title ?: "",
                category ?: "",
                image ?: "",
                about ?: "",
                likes ?: -1,
                size ?: "",
                color ?: ""
            )
        }
        call.respond(designs)
    }


}



    /*
    get("/allDesigns") {
        try {
            val apiResponse = designRepository.getAllDesigns()
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only Numbers Allowed."),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Heroes not Found."),
                status = HttpStatusCode.NotFound
            )
        }
    }

     */
