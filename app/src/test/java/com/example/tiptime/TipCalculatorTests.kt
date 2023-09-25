package com.example.tiptime

import com.example.tiptime.utils.Utils.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {
    /*
    There are a few things that you should know about writing automated tests.
    The following list of concepts apply to local and instrumentation tests.
    They might seem abstract at first, but you become more familiar with
    them by the end of this codelab.

    Write automated tests in the form of methods.

    Annotate the method with the @Test annotation. This lets the compiler know that the
    method is a test method and runs the method accordingly.

    Ensure that the name clearly describes what the test tests for and
    what the expected result is.

    Test methods don't use logic like regular app methods.
    They aren't concerned with how something is implemented.
    They strictly check an expected output for a given input.
    That is to say, test methods only execute a set of instructions
    to assert that an app's UI or logic functions correctly.
    You don't need to understand what this means yet because you
    see what this looks like later, but remember that test code
    may look quite different from the app code that you're used to.

    Tests typically end with an assertion, which is used to ensure
    that a given condition is met. Assertions come in the form of a
    method call that has assert in its name. For example: the assertTrue()
    assertion is commonly used in Android testing. Assertion statements
    are used in most tests, but they're rarely used in actual app code.

    Note: There are many assertions in the JUnit library.
    Some common assertions that you might encounter are:

    assertEquals()
    assertNotEquals()
    assertTrue()
    assertFalse()
    assertNull()
    assertNotNull()
    assertThat()
     */

    @Test
    fun calculateTip_20PercentNoRoundup(){
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount, tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}