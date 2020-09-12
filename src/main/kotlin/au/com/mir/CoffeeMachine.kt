package au.com.mir

object CoffeeMachine {
    fun makeDrink(request: Orders): IOrderResponse {
        val drinkType = request.getOrderType()
        val getMessage = request.getOrderDetails()

        return if (drinkType == "M")
            Message(getMessage)
        else
            Drinks.makeOrder(request)
    }
}

