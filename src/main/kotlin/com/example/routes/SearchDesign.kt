package com.example.routes

import com.example.db.databaseConnection
import com.example.entites.DesignEntity
import com.example.models.Design
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.ktorm.dsl.*

/**
 * a get request which send a query to the database to search the titles with a key word sent in the queryParameteres
 */
fun Route.searchDesign() {
    val db = databaseConnection.database

    get("/designs/search"){
        val title = call.request.queryParameters["title"]?:""


        val designs = db.from(DesignEntity).select().where(
            DesignEntity.title like "%${title.lowercase()}%"
        ).map {
            val id =it[DesignEntity.id]
            val title=it[DesignEntity.title]
            val category=it[DesignEntity.category]
            val image=it[DesignEntity.image]
            val about=it[DesignEntity.about]
            val likes=it[DesignEntity.likes]
            val size=it[DesignEntity.size]
            val color=it[DesignEntity.color]
            Design(id?:-1,title?:"",category?:"",image?:"",about?:"",likes?:-1,size?:"",color?:"")
        }
        call.respond(designs)
    }
}
    /*
    get("/Designs/search") {
        val name = call.request.queryParameters["name"]

        val apiResponse = designRepository.searchDesigns(name = name)
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
*/

