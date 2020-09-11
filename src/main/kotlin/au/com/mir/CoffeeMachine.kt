package au.com.mir

object CoffeeMachine {
    fun makeDrink(request: String): Drink {
        val drinkType = request.split(':')[0]

        val sugar = request.split(':')[1].toInt()
        val stick = sugar > 0

        return Drinks.order(drinkType, sugar, stick)

    }
}

