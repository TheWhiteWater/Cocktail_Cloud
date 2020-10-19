package nz.co.redice.cocktailcloud.repo.locals.entity


open class MeasureUnit(var volume: Double = 0.0) {

    class Milliliter(volume: Double) : MeasureUnit(volume) {
        fun convertToOunces() = Ounce(volume / 29.5735)
    }

    class Ounce(volume: Double) : MeasureUnit(volume) {
        fun convertToMilliliters() = Milliliter(volume * 29.5735)
    }
}
