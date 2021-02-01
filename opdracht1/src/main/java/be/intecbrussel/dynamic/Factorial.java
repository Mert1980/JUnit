package be.intecbrussel.dynamic;

public class Factorial {

    public int getFactorial(int number) throws NegativeNumberInputException{
        if(number < 0){
            throw new NegativeNumberInputException("Number must be > or = to 0 ");
        }
        int factorial = 1;
        for (int i = factorial; i <= number; i++) {
            factorial*=i;
        }
        return factorial;
    }
}
