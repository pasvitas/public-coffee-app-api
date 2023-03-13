package ru.pasvitas.coffeeApi.controllers

import org.lightcouch.CouchDbClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import ru.pasvitas.coffeeApi.model.CoffeeRecipe
import ru.pasvitas.coffeeApi.model.CoffeeRecipeRoot
import ru.pasvitas.coffeeApi.model.Response
import ru.pasvitas.coffeeApi.model.SuggestionRecipe
import java.lang.Exception


@RestController
@RequestMapping("/coffeeapi/")
class SuggestController {
    @Autowired
    private lateinit var dbClient: CouchDbClient

    @PostMapping("/suggestRecipe")
    fun editDragon(@RequestBody suggestion: SuggestionRecipe): Response {
        return try {
            val suggestData = dbClient.find(CoffeeRecipeRoot::class.java,"suggestionRecipes")
            if (!suggestData.recipes.containsKey(suggestion.type)) {
                suggestData.recipes[suggestion.type] = mutableListOf<CoffeeRecipe>()
            }
            suggestData.recipes[suggestion.type]!!.add(suggestion.recipe)
            Response(true, "Success")
        }
        catch (e: Exception) {
            Response(true, e.message!!)
        }
    }

}