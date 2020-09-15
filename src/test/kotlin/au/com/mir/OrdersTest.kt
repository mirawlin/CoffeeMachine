package au.com.mir

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object OrdersTest: Spek({
    describe("getOrderType") {
        it("should take the first part of string delimited by :") {
            // GIVEN
            val order = "T:1:0"
            val order2 = "Th:1:0"

            // WHEN
            val result = Orders(order).getOrderType()
            val result2 = Orders(order2).getOrderType()

            // THEN
            assertEquals("T", result)
            assertEquals("Th", result2)
        }
    }

    describe("getOrderDetails") {
        it("should take the first part of string delimited by :") {
            // GIVEN
            val order = "T:1:0"

            // WHEN
            val result = Orders(order).getOrderDetails()

            // THEN
            assertEquals("1", result)
        }
    }
})
