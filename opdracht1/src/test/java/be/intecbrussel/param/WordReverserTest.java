package be.intecbrussel.param;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WordReverserTest {

    private WordReverser reverser;

    @BeforeAll
    public void initializeWordReverser(){
        reverser = new WordReverser();
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void testReverseWord_WhenSourceIsEmpty_ThenResultIsEmpty(String text){
        Assertions.assertEquals(text, reverser.reverseWord(text));
    }

    @ParameterizedTest
    @CsvSource({
            "Boot, tooB",
            "Vliegen, negeilV",
            "mert, trem"
    })
    void testReverseWord_WhenPassingAWord_ThenResultIsReversedWord(String word, String expected){
        Assertions.assertEquals(expected, reverser.reverseWord(word));
    }

    @ParameterizedTest
    @CsvSource({
            "Vliegen , negeilV",
            " Book, kooB",
            " camel , lemac"
    })
    void testReverseWord_WhenPassingAWordWithSpace_ThenResultIsTrimmedReversedWord(String word, String expected){
        Assertions.assertEquals(expected, reverser.reverseWord(word));
    }

    @Test
    void testReverseWord_WhenPassingNull_ThenResultIsTheWord(){
        String word = null;
        Assertions.assertNull(reverser.reverseWord(word));
    }

}