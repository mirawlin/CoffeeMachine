package au.com.mir

object Drinks {
    fun makeOrder(order: Orders): IOrderResponse {
        val drinkType = order.getOrderType()
        val sugar = order.getOrderDetails().toIntOrNull() ?: 0
        val stick = sugar > 0

        return when(drinkType) {
            "T" -> Tea(sugar,stick)
            "H" -> HotChocolate(sugar,stick)
            "C" -> Coffee(sugar,stick)
            else -> throw RuntimeException("Not Valid Input")
        }
    }
}
