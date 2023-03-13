package ru.pasvitas.coffeeApi.model

data class CoffeeRecipe(val title: String, val ingrs: Map<String, Int>, val text: List<String>, val imageUrl: String)

data class SuggestionRecipe(val type: String, val author: String, val recipe: CoffeeRecipe)