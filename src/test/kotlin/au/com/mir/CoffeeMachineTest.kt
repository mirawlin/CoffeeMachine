package au.com.mir

import au.com.mir.Drink.*
import org.junit.jupiter.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object CoffeeMachineTest: Spek({
    describe("make Drink") {
        it("should take a string T:1:0 and make a tea with one sugar and a stick") {
            // GIVEN
            val command = "T:1:0"
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command)

            // THEN
            Assertions.assertEquals(Tea(1, true), result)
        }

        it("should take a string H:0:0 and make a chocolate with 0 sugar and 0 stick") {
            // GIVEN
            val command = "H:0:0"
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command)

            // THEN
            Assertions.assertEquals(HotChocolate(0, false), result)
        }

        it("should take a string C:2:0 and make a chocolate with 2 sugar and 1 stick") {
            // GIVEN
            val command = "C:2:0"
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command)

            // THEN
            Assertions.assertEquals(Coffee(2, true), result)
        }

//        it("should take a string M:blah and returns blah") {
//            // GIVEN
//            val command = "M:blah"
//            val coffeeMachine = CoffeeMachine
//
//            // WHEN
//            val result = coffeeMachine.makeDrink(command)
//
//            // THEN
//            Assertions.assertEquals(Message("blah"), result)
//        }
    }
})
