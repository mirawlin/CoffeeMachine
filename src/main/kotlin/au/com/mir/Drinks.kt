package au.com.mir

object Drinks {
    fun makeOrder(order: Orders, amount: Double): IOrderResponse {
        val drinkType = order.getOrderType()
        val sugar = order.getOrderDetails().toIntOrNull() ?: 0
        val stick = sugar > 0

        return when(drinkType) {
            "T" -> makeDrinkIfAmountValid(amount, Tea(sugar,stick))
            "H" -> makeDrinkIfAmountValid(amount, HotChocolate(sugar,stick))
            "C" -> makeDrinkIfAmountValid(amount, Coffee(sugar,stick))
            else -> throw RuntimeException("Not Valid Input")
        }
    }

    private fun makeDrinkIfAmountValid(amount: Double, drink: Drink): IOrderResponse {
        return if (amount >= drink.cost)
            drink
        else Message("Not enough money")
    }
}
