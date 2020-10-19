package nz.co.redice.cocktailcloud.repo

import io.reactivex.Single
import nz.co.redice.cocktailcloud.repo.remotes.CocktailService
import nz.co.redice.cocktailcloud.repo.remotes.models.CocktailApiResponse
import javax.inject.Inject

class Repository @Inject constructor(
    private val cocktailService: CocktailService
) {

    fun getCocktailByIngredients(names: String): Single<CocktailApiResponse> {
        return cocktailService.queryDrinksByIngredients(name = names)
    }


    fun getCocktailByName(name: String): Single<CocktailApiResponse> {
        return cocktailService.queryDrinkByName(name = name)
    }

    fun getPopularCocktails(): Single<CocktailApiResponse> {
        return  cocktailService.queryPopularDrinks()
    }
}