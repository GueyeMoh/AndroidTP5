package com.example.tp5

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import java.util.*

class Repository {

    val breaking = ArrayList<Characters>()
     private suspend fun startNetworkCall(){
        val client = HttpClient(CIO){
            install(JsonFeature){
                serializer = GsonSerializer()
            }
        }
        val elmnt: Characters = client.get{url("https://www.breakingbadapi.com/api/characters")}
         val charac = elmnt.iterator()
         while (charac.hasNext()){
             if (charac!=null){
                 breaking.add(charac.next())
             }
         }
    }
}