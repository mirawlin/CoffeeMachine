package au.com.mir

import au.com.mir.Drink.*

open class Drink {
    data class Tea(val sugar: Int, val stick: Boolean): Drink()
    data class Coffee(val sugar: Int, val stick: Boolean): Drink()
    data class HotChocolate(val sugar: Int, val stick: Boolean): Drink()
    data class Message(val message: String): Drink()

}

object Drinks {
    fun order(order: String, sugar: Int, stick: Boolean): Drink {
        return when(order) {
            "T" -> Tea(sugar,stick)
            "H" -> HotChocolate(sugar,stick)
            "C" -> Coffee(sugar,stick)
//            "M" -> Message(message)

            else -> Drink()
        }
    }
}
