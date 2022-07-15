package com.example.routes

import com.example.db.databaseConnection
import com.example.entites.DesignEntity
import com.example.models.Design
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.ktorm.dsl.*

/**
 * GET : to filter the Design to its corresponding Category
 */
fun Route.filterDesign() {
    val db = databaseConnection.database


    get("/designs/filter"){
        val category = call.request.queryParameters["category"]?:""

        val designs = db.from(DesignEntity).select().where(
            DesignEntity.category eq category
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
/*
    get("/Designs/filter") {
        val name = call.request.queryParameters["name"]

        val apiResponse = designRepository.filterDesigns(name = name)
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
    */

}