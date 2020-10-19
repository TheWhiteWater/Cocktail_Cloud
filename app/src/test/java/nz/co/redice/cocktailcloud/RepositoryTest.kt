package nz.co.redice.cocktailcloud

import nz.co.redice.cocktailcloud.repo.remotes.CocktailService
import nz.co.redice.cocktailcloud.repo.remotes.models.CocktailApiResponse
import nz.co.redice.cocktailcloud.repo.remotes.models.DrinkX
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Matcher
import org.hamcrest.Matchers.containsString
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class RepositoryTest {

    @get:Rule
    val mockWebServer = MockWebServer()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val cocktailService by lazy {
        retrofit.create(CocktailService::class.java)
    }


    private fun getJson(path: String): String {
        val uri = this.javaClass.classLoader.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

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


    @Test
    fun testThatEmitApiResponse() {
        mockWebServer.enqueue(MockResponse()
            .setBody(getJson("mockJson.json"))
            .setResponseCode(200))

        val testObserver =
            cocktailService.queryPopularDrinks().test()

        testObserver.assertValue(CocktailApiResponse(listOf(drinkX)))
    }


    @Test
    fun getPopularCocktails_pathTest() {
        mockWebServer.enqueue(MockResponse()
                .setBody(getJson("mockJson.json"))
                .setResponseCode(200))

        val testObserver =
            cocktailService.queryPopularDrinks().test()

        testObserver.assertNoErrors()
        assertThat(mockWebServer.takeRequest().path, containsString("v2/1/popular.php"))
    }

}


