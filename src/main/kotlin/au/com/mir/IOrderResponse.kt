package au.com.mir

interface IOrderResponse

sealed class Drink : IOrderResponse

data class Tea(val sugar: Int, val stick: Boolean) : Drink()
data class Coffee(val sugar: Int, val stick: Boolean) : Drink()
data class HotChocolate(val sugar: Int, val stick: Boolean) : Drink()
data class Message(val message: String) : IOrderResponse

