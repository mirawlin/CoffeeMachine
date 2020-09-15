package au.com.mir

object Drinks {
    fun makeOrder(order: Orders, amount: Double): IOrderResponse {
        val drinkType = order.getOrderType()
        val sugar = order.getOrderDetails().toIntOrNull() ?: 0
        val stick = sugar > 0

        val extraHot = drinkType.length > 1

        return when(drinkType[0].toString()) {
            "T" -> makeDrinkIfAmountValid(amount, Tea(sugar,stick, extraHot))
            "H" -> makeDrinkIfAmountValid(amount, HotChocolate(sugar,stick, extraHot))
            "C" -> makeDrinkIfAmountValid(amount, Coffee(sugar,stick, extraHot))
            "O" -> makeDrinkIfAmountValid(amount, OrangeJuice(sugar,stick, extraHot))
            else -> throw RuntimeException("Not Valid Input")
        }
    }

    private fun makeDrinkIfAmountValid(amount: Double, drink: Drink): IOrderResponse {
        return if (amount >= drink.cost)
            drink
        else Message("Not enough money")
    }
}
