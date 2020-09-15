package au.com.mir

interface IOrderResponse

sealed class Drink(open val cost: Double) : IOrderResponse

data class Tea(val sugar: Int, val stick: Boolean, val extraHot: Boolean, override val cost: Double = 0.4) : Drink(cost)
data class Coffee(val sugar: Int, val stick: Boolean, val extraHot: Boolean, override val cost: Double = 0.6) : Drink(cost)
data class HotChocolate(val sugar: Int, val stick: Boolean, val extraHot: Boolean, override val cost: Double = 0.5) : Drink(cost)
data class OrangeJuice(val sugar: Int = 0, val stick: Boolean, val extraHot: Boolean, override val cost: Double = 0.6) : Drink(cost)
data class Message(val message: String) : IOrderResponse

