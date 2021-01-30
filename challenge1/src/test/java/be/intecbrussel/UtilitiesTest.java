package be.intecbrussel;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UtilitiesTest {

    private Utilities utilities;

    @BeforeAll
    public void initializeUtilities(){
        utilities = new Utilities();
    }

    @Test
    void testGivenCharArray_WithLengthOfSourceArray_IsLessThanGivenNumber(){
        char[] sourceArray = {'h', 'e', 'l', 'l', 'o'};
        Assertions.assertArrayEquals(sourceArray, utilities.everyNthChar(sourceArray, 6));
    }

    @Test
    void testGivenCharArray_WithLengthOfSourceArray_IsMoreThanGivenNumber(){
        String text = "Hello to unit testing with JUnit";
        char[] sourceArray = text.toCharArray();
        char[] expected = "el oui etn ihJnt".toCharArray();
        int number = 2;

        Assertions.assertArrayEquals(expected, utilities.everyNthChar(sourceArray, number));
    }

    @Test
    void testGivenCharArray_WithLengthOfSourceArray_IsEqualToGivenNumber(){
        String text = "ab";
        char[] sourceArray = text.toCharArray();
        char[] expected = "b".toCharArray();
        int number = 2;

        Assertions.assertArrayEquals(expected, utilities.everyNthChar(sourceArray, number));
    }

    @Test
    void testGivenCharArray_WithSourceArrayIsNull_ThenResultIsNull(){
        char[] sourceArray = null;
        Assertions.assertNull(utilities.everyNthChar(sourceArray, 2));
    }

    @Test
    void testRemovePairs_WhenLengthOfTextIsLessThanTwo_ThenResultIsText(){
        String text = "a";
        Assertions.assertEquals("a", utilities.removePairs(text));
    }

    @Test
    void testRemovePairs_WhenLengthOfTextIsEqualToTwo_ThenResultHasNotPairs(){
        String text = "aa";
        Assertions.assertEquals("a", utilities.removePairs(text));
    }

    @ParameterizedTest
    @CsvSource({"ABBCDEEF, ABCDEF",
                "ABCBDEEF, ABCBDEF",
                "ABCDEFF, ABCDEF",
                "112233445566, 123456",
                "ZYZQQB, ZYZQB",
                "A, A"
    })
    void testRemovePairs_WhenLengthOfTextIsMoreThanTwo_ThenResultHasNotPairs(String str, String expected){
        Assertions.assertEquals(expected, utilities.removePairs(str));
    }

    @Test
    void testRemovePairs_WhenSourceIsNull_ThenResultIsNull(){
        Assertions.assertNull(null, utilities.removePairs(null));
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void testRemovePairs_WhenSourceIsEmpty_ThenResultIsEmpty(String text){
        Assertions.assertEquals(text, utilities.removePairs(text));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 2, 181",
            "4, 2, 120",
            "10, 5, 300"
    })
    void testConverter_WhenPassingTwoPositiveNumbers_ThenResultIsInteger(int a, int b, int expected){
        Assertions.assertEquals(expected, utilities.converter(a, b));
    }

    @ParameterizedTest
    @MethodSource("twoTntProvider")
    void testConverter_WithMethodSource_WhenPassingTwoPositiveNumbers_ThenResultIsInteger(int a, int b, int expected){
        Assertions.assertEquals(expected, utilities.converter(a, b));
    }

    static Stream<Arguments> twoTntProvider() {
        return Stream.of(
                Arguments.arguments(8, 4, 240),
                Arguments.arguments(6, 3, 180),
                Arguments.arguments(12, 6, 360)
        );
    }

    @Test
    @DisplayName("throws ArithmeticException when second argument is zero")
    void testConverter_WhenSecondArgumentIsZero_ThenThrowsArithmeticException(){
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () ->
                utilities.converter(10, 0));
        Assertions.assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void testNullIfOddLength_WhenPassingStringOddLength_ThenResultIsNull(){
        Assertions.assertNull(utilities.nullIfOddLength("camel"));
    }

    @Test
    void testNullIfOddLength_WhenPassingStringOddLength_ThenResultIsGivenString(){
        Assertions.assertEquals("book", utilities.nullIfOddLength("book"));
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testNullIfOddLength_WithExplicitLocalMethodSource(String argument) {
        Assertions.assertNull(utilities.nullIfOddLength(argument));
    }

    static Stream<String> stringProvider() {
        return Stream.of("camel", "apple");
    }

    @TestFactory
    Stream<DynamicTest> testNullIfOddLength_WithDynamicTest() {
        return Stream.of("book", "boos", "nine", "seek")
                .map(text -> dynamicTest(text, () -> Assertions.assertNotNull(utilities.nullIfOddLength(text))));
    }

}
