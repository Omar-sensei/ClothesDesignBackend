package com.example.routes

import com.example.db.databaseConnection
import com.example.entites.DesignEntity
import com.example.models.ApiResponse
import com.example.models.designRequest
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject
import org.ktorm.dsl.insert
import java.awt.Image
import java.io.File
import java.net.URI
import javax.imageio.ImageIO


/**
 * this is for adding a new design to the server
 * one for the text
 * and the second for the image which is sent as a multipart
 */
fun Route.addDesign() {
    val db = databaseConnection.database
    var fileDescription = ""
    var fileName = ""
    post("/designs"){
        val request = call.receive<designRequest>()

        val result = db.insert(DesignEntity){
            set(it.title,request.title)
            set(it.category,request.category)
            set(it.size,request.size)
            set(it.color,request.color)
            set(it.likes,request.likes)
            set(it.about,request.about)
            set(it.image,request.image)

        }

        if (result==1){
            call.respond(
                message = ApiResponse(success = true, message = "Sucessfully inserted"),
                status = HttpStatusCode.OK
            )
        }
        else{
            call.respond(
                message = ApiResponse(success = false, message = "Cant insert"),
                status = HttpStatusCode.BadRequest
            )
        }
    }




    post("/images") {
        val multipartData = call.receiveMultipart()

        multipartData.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> {
                    fileDescription = part.value
                }
                is PartData.FileItem -> {
                    fileName = part.originalFileName as String
                    var fileBytes = part.streamProvider().readBytes()
                    File("src/main/resources/images/$fileName").writeBytes(fileBytes)
                    File("build/resources/main/images/$fileName").writeBytes(fileBytes)

                }
            }
        }

        call.respondText("$fileDescription is uploaded to 'uploads/$fileName'")
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

    post("/add"){
        try {
         //   val request =call.receive<note>()
         //   println(request.St)
          //  designRepository.notes.add(request)
            val apiResponse = designRepository.Designs
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )

        }catch (e : Exception){
            call.respond(
                message = ApiResponse(success = false, message = "${e.message}"),
                status = HttpStatusCode.BadRequest
            )
        }

    }*/
}