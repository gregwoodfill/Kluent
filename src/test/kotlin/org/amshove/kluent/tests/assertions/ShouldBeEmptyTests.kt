package org.amshove.kluent.tests.assertions

import org.amshove.kluent.shouldBeEmpty
import org.jetbrains.spek.api.Spek
import kotlin.test.assertFails

class ShouldBeEmptyTests : Spek({
    given("the shouldBeEmpty method") {
        on("passing an empty array") {
            it("should pass") {
                val arr = arrayOf<String>()
                arr.shouldBeEmpty()
            }
        }
        on("passing an empty iterable") {
            it("should pass") {
                val iterable: Iterable<String> = listOf()
                iterable.shouldBeEmpty()
            }
        }
        on("passing an empty map") {
            it("should pass") {
                val map = mapOf<Int, String>()
                map.shouldBeEmpty()
            }
        }
        on("passing a non empty array") {
            it("should fail") {
                val arr = arrayOf("Hi")
                assertFails({ arr.shouldBeEmpty() })
            }
        }
        on("passing a non empty iterable") {
            it("should fail") {
                val iterable = listOf("Hi")
                assertFails({ iterable.shouldBeEmpty() })
            }
        }
        on("passing a non empty map") {
            it("should fail") {
                val map = mapOf(1 to "Hi")
                assertFails({ map.shouldBeEmpty() })
            }
        }
    }
})

