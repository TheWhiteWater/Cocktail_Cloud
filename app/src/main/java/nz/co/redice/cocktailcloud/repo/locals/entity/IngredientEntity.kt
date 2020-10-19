package nz.co.redice.cocktailcloud.repo.locals.entity

import io.realm.RealmList

open class IngredientEntity(
    var name: String = "",
    var drinkEntities: RealmList<DrinkEntity> = RealmList()
)