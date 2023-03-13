package ru.pasvitas.coffeeApi.controllers

import org.lightcouch.CouchDbClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.pasvitas.coffeeApi.model.CoffeeRecipe
import ru.pasvitas.coffeeApi.model.CoffeeRecipeRoot

@RestController
@RequestMapping("/coffeeapi")
class MainController {
    @Autowired
    private lateinit var dbClient: CouchDbClient

    @RequestMapping("/getRecipes")
    fun getAllRecipesName() : Set<String> {
        return dbClient.find(CoffeeRecipeRoot::class.java, "recipes").recipes.keys
    }

    @RequestMapping("/getRecipePages")
    fun getRecipePages(@RequestParam("type") type: String) : Int {
        return (dbClient.find(CoffeeRecipeRoot::class.java, "recipes").recipes[type] ?: error("")).size
    }

    @RequestMapping("/getRecipe")
    fun getRecipe(@RequestParam("type") type: String) : List<CoffeeRecipe> {
        return (dbClient.find(CoffeeRecipeRoot::class.java, "recipes").recipes[type] ?: error(""))
    }
}