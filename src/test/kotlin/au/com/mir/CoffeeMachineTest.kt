package au.com.mir

import org.junit.jupiter.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object CoffeeMachineTest : Spek({
    describe("make Drink") {
        it("should take a string T:1:0 and make a tea with one sugar and a stick") {
            // GIVEN
            val command = Orders("T:1:0")
            val money = 0.4
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(Tea(1, stick = true, extraHot = false), result)
        }

        it("should take an order T:1:0 with >= 0.4 and make a tea with one sugar and a stick") {
            // GIVEN
            val command = Orders("T:1:0")
            val money = 0.6
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(Tea(1, stick = true, extraHot = false), result)
        }

        it("should take a string Th:1:0 and make an extra hot tea with one sugar and a stick") {
            // GIVEN
            val command = Orders("Th:1:0")
            val money = 0.4
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(Tea(1, stick = true, extraHot = true), result)
        }

        it("should take an order T:1:0 with < 0.4 and return an error message") {
            // GIVEN
            val command = Orders("T:1:0")
            val money = 0.1
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(Message("Not enough money"), result)
        }

        it("should take a string H:0:0 and make a chocolate with 0 sugar and 0 stick") {
            // GIVEN
            val command = Orders("H:0:0")
            val money = 0.5
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(HotChocolate(0, stick = false, extraHot = false), result)
        }

        it("should take an order H:0:0 with >= 0.5 and make a chocolate with 0 sugar and 0 stick") {
            // GIVEN
            val command = Orders("H:0:0")
            val money = 0.7
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(HotChocolate(0, stick = false, extraHot = false), result)
        }

        it("should take an order Hh:0:0 with >= 0.5 and make an extra hot chocolate with 0 sugar and 0 stick") {
            // GIVEN
            val command = Orders("Hh:0:0")
            val money = 0.7
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(HotChocolate(0, stick = false, extraHot = true), result)
        }

        it("should take an order H:0:0 with < 0.5  and return an error message") {
            // GIVEN
            val command = Orders("H:0:0")
            val money = 0.3
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(Message("Not enough money"), result)
        }

        it("should take a string C:2:0 and make a chocolate with 2 sugar and 1 stick") {
            // GIVEN
            val command = Orders("C:2:0")
            val money = 0.6
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(Coffee(2, stick = true, extraHot = false), result)
        }

        it("should take an order C:2:0 and amount >= 0.6 and make a chocolate with 2 sugar and 1 stick") {
            // GIVEN
            val command = Orders("C:2:0")
            val money = 0.9
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(Coffee(2, stick = true, extraHot = false), result)
        }

        it("should take an order Ch:2:0 and amount >= 0.6 and make an extra hot chocolate with 2 sugar and 1 stick") {
            // GIVEN
            val command = Orders("Ch:2:0")
            val money = 0.9
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(Coffee(2, stick = true, extraHot = true), result)
        }

        it("should take an order C:2:0 and amount < 0.6 and return an error message") {
            // GIVEN
            val command = Orders("C:2:0")
            val money = 0.2
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(Message("Not enough money"), result)
        }

        it("should take a string M:blah and returns blah") {
            // GIVEN
            val command = Orders("M:blah")
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command)

            // THEN
            Assertions.assertEquals(Message("blah"), result)
        }

        it("should throw an error if none of the possible options are given") {
            // GIVEN
            val command = Orders("A:We have an invalid message")
            val coffeeMachine = CoffeeMachine

            // WHEN

            val thrown: RuntimeException = Assertions.assertThrows(RuntimeException::class.java) {
                coffeeMachine.makeDrink(command)
            }

            // THEN
            Assertions.assertEquals("Not Valid Input", thrown.message)
        }

        it("should take an order O:: and amount >= 0.6 and make an orange juice") {
            // GIVEN
            val command = Orders("O::")
            val money = 0.9
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(OrangeJuice(0, stick = false, extraHot = false), result)
        }

        it("should take an order O:: and amount < 0.6 and return not enough money") {
            // GIVEN
            val command = Orders("O::")
            val money = 0.1
            val coffeeMachine = CoffeeMachine

            // WHEN
            val result = coffeeMachine.makeDrink(command, money)

            // THEN
            Assertions.assertEquals(Message("Not enough money"), result)
        }
    }
})
