package nz.co.redice.cocktailcloud


import androidx.test.platform.app.InstrumentationRegistry
import io.realm.Realm
import io.realm.RealmConfiguration
import org.junit.After
import org.junit.Before


class RealmDatabaseTest {


    private lateinit var realm: Realm

    @Before
    fun initDatabase() {
        Realm.init(InstrumentationRegistry.getInstrumentation().targetContext)
        val testConfig = RealmConfiguration.Builder()
            .name("realm_test.db")
            .inMemory()
            .build();
        realm = Realm.getInstance(testConfig)
    }

    @After
    fun closeDatabase() {
        realm.close()
    }

//    @Test
//    fun emptyBaseHasNoEntries() {
//        val cocktails = realm.where<DrinkEntity>().findAll()
//        assertTrue(cocktails.isEmpty())
//    }
//
//
//
//    @Test
//    fun databaseSavesDrinkEntries() {
//        val drink = DrinkEntity(name = "margarita")
//        realm.beginTransaction()
//        realm.insert(drink)
//        realm.commitTransaction()
//
//        val cocktails = realm.where<DrinkEntity>().findAll()
//        val testee = mutableListOf<DrinkEntity>()
//        testee.addAll(cocktails)
//
//
//    }

}