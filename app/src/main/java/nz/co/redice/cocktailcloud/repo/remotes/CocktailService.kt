package nz.co.redice.cocktailcloud.repo.remotes

import io.reactivex.Single
import nz.co.redice.cocktailcloud.repo.remotes.models.CocktailApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {

    companion object {
        const val API_KEY = "9973533"
    }

    @GET("v2/1/search.php")
    fun queryDrinkByName(
        @Query("s") name: String
    ): Single<CocktailApiResponse>


    @GET("v2/1/filter.php")
    fun queryDrinksByIngredients(
        @Query("") apiKey: String = API_KEY,
        @Query("i") name: String
    ): Single<CocktailApiResponse>

    @GET("v2/1/popular.php")
    fun queryPopularDrinks(
        @Query("apiKey") apiKey: String = API_KEY,
    ): Single<CocktailApiResponse>
}