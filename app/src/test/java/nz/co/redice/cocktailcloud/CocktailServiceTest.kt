package nz.co.redice.cocktailcloud

import com.github.javafaker.Faker
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import nz.co.redice.cocktailcloud.repo.Repository
import nz.co.redice.cocktailcloud.repo.remotes.CocktailService
import nz.co.redice.cocktailcloud.repo.remotes.models.CocktailApiResponse
import nz.co.redice.cocktailcloud.repo.remotes.models.DrinkX
import org.junit.Test

class CocktailServiceTest {

    private val cocktailService: CocktailService = mock()
    private val repository = Repository(cocktailService)
    var faker = Faker()

    private val drinkX = DrinkX(
        idDrink = "178336",
        strDrink = "Blueberry Mojito",
        strCategory = "Cocktail",
        strAlcoholic = "Alcoholic",
        strGlass = "Highball glass",
        strInstructions = "Muddle the blueberries with the other ingredients and serve in a highball glass. Garnish with mint and a half slice of lime.",
        strDrinkThumb = "https://www.thecocktaildb.com/images/media/drink/07iep51598719977.jpg",
        strIngredient1 = "Dark Rum",
        strIngredient2 = "Lime Juice",
        strIngredient3 = "Sugar",
        strIngredient4 = "Blueberries",
        strIngredient5 = "Lemon-lime soda",
        strMeasure1 = "2 shots",
        strMeasure2 = "1 shot",
        strMeasure3 = "Dash",
        strMeasure4 = "Whole",
        strMeasure5 = "Top"
    )

    private val mockResponse = CocktailApiResponse(listOf(drinkX))

    @Test
    fun service_emitsResponseModel() {
        whenever(cocktailService.queryPopularDrinks())
            .thenReturn(Single.just(mockResponse))

        val testObserver =
            repository.getPopularCocktails().test()

        testObserver.assertValue(mockResponse)

    }

}