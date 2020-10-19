package nz.co.redice.cocktailcloud.repo.locals.entity

import io.realm.RealmList

open class DrinkEntity(
    var id: Int = 0,
    var isAlcoholic: Boolean = false,
    var category: String ="",
    var name: String = "",
    var alternate: String = "",
    var thumb: String = "",
    var glassType: String = "",
    var iba: String = "",
    var instructions: String = "",
    var tags: String = "",
    var videoLink: String = "",
    var ingredients: RealmList<IngredientEntity> = RealmList(),
    var ingredientMeasures: RealmList<MeasureUnit> = RealmList()
)  {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}