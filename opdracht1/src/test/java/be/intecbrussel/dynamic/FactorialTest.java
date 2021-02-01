package be.intecbrussel.dynamic;

import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FactorialTest {

    private Factorial fact;

    @BeforeAll
    public void initializeWordReverser(){
        fact = new Factorial();
    }

    @TestFactory
    Collection<DynamicTest> testGetFactorial_WhenPassingPositiveIntegers_ThenResultFactorials() {
        return Arrays.asList(
                dynamicTest("Test with integer, result is not Null", ()->assertNotNull(fact.getFactorial(12))),
                dynamicTest("Test with negative integer, throws NegativeNumberInputException",
                        ()->assertThrows(NegativeNumberInputException.class,()->fact.getFactorial(-12))),
                dynamicTest("Test with zero", ()->assertEquals(1, fact.getFactorial(0))),
                dynamicTest("Test with positive integer", ()->assertEquals(120, fact.getFactorial(5))),
                dynamicTest("Test with positive integer", ()->assertEquals(24, fact.getFactorial(4)))
        );
    }
}