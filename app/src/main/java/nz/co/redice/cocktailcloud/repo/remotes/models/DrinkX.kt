package nz.co.redice.cocktailcloud.repo.remotes.models

import com.google.gson.annotations.SerializedName

data class DrinkX(
    var dateModified: String = "",
    var idDrink: String = "",
    var strAlcoholic: String = "",
    var strCategory: String = "",
    var strCreativeCommonsConfirmed: String = "",
    var strDrink: String = "",
    var strDrinkAlternate: String = "",
    var strDrinkDE: String = "",
    var strDrinkES: String = "",
    var strDrinkFR: String = "",
    var strDrinkThumb: String = "",
    @SerializedName("strDrinkZH-HANS")
    var strDrinkZH_HANS: String = "",
    @SerializedName("strDrinkZH-HANT")
    var strDrinkZH_HANT: String = "",
    var strGlass: String = "",
    var strIBA: String = "",
    var strIngredient1: String = "",
    var strIngredient10: String = "",
    var strIngredient11: String = "",
    var strIngredient12: String = "",
    var strIngredient13: String = "",
    var strIngredient14: String = "",
    var strIngredient15: String = "",
    var strIngredient2: String = "",
    var strIngredient3: String = "",
    var strIngredient4: String = "",
    var strIngredient5: String = "",
    var strIngredient6: String = "",
    var strIngredient7: String = "",
    var strIngredient8: String = "",
    var strIngredient9: String = "",
    var strInstructions: String = "",
    var strInstructionsDE: String = "",
    var strInstructionsES: String = "",
    var strInstructionsFR: String = "",
    @SerializedName("strInstructionsZH-HANS")
    var strInstructionsZH_HANS: String = "",
    @SerializedName("strInstructionsZH-HANT")
    var strInstructionsZH_HANT: String = "",
    var strMeasure1: String = "",
    var strMeasure10: String = "",
    var strMeasure11: String = "",
    var strMeasure12: String = "",
    var strMeasure13: String = "",
    var strMeasure14: String = "",
    var strMeasure15: String = "",
    var strMeasure2: String = "",
    var strMeasure3: String = "",
    var strMeasure4: String = "",
    var strMeasure5: String = "",
    var strMeasure6: String = "",
    var strMeasure7: String = "",
    var strMeasure8: String = "",
    var strMeasure9: String = "",
    var strTags: String = "",
    var strVideo: String = ""
)