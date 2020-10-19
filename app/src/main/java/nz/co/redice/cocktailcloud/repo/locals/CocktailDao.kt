package nz.co.redice.cocktailcloud.repo.locals

import io.realm.Realm


class CocktailDao(
    private val db: Realm
) {

//    fun findAllAsync(): RealmResults<DrinkEntity> = db.where(DrinkEntity::class.java).findAllAsync()


//    fun findById(id: Int): DrinkEntity? {
//        return db.where(DrinkEntity::class.java)
//            .equalTo("id", id)
//            .findFirst()
//    }

//    fun findByIngredient(ingredient: IngredientEntity): List<DrinkEntity> {
//        val drinks = mutableListOf<DrinkEntity>()
//        val result = db.where(IngredientEntity::class.java)
//            .equalTo("name", ingredient.name)
//            .findFirstAsync()
//
//        drinks.addAll(result.drinkEntities)
//        return drinks
//    }

//    fun findNonAlcoholicByIngredient(ingredient: IngredientEntity): List<DrinkEntity> {
//        return findByIngredient(ingredient).filter { !it.isAlcoholic }
//    }

//    fun copyOrUpdate(drink: DrinkEntity): DrinkEntity {
//        var drinkEntry: DrinkEntity
//        try {
//            db.beginTransaction()
//            drinkEntry = db.copyToRealmOrUpdate(drink)
//            db.commitTransaction()
//        } catch (e: Exception) {
//            db.cancelTransaction()
//            throw e
//        }
//        return drinkEntry
//    }


}
