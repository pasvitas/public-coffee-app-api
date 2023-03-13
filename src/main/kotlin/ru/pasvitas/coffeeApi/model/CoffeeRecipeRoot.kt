package ru.pasvitas.coffeeApi.model

import org.lightcouch.Document

data class CoffeeRecipeRoot(val recipes: MutableMap<String, MutableList<CoffeeRecipe>>) : Document()