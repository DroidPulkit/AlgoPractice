import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(findPrimeNumberOptimizationThree(100000000));
    }


    //This is the brute force method
    //This method sucks as we add more and more zeros
    //Kind of big O(n square)
    static List<Integer> findPrimeNumber(int size)
    {
        List<Integer> listOfPrimeNumbers = new ArrayList<>();
        for(int i = 1; i <= size; i++)
        {
            int counter = 0;
            for(int j = 1; j <= i; j++)
            {
                if (i%j == 0)
                {
                    counter++;
                }
            }
            if(counter == 2)
            {
                listOfPrimeNumbers.add(i);
            }
        }
        return listOfPrimeNumbers;
    }

    //This method is cutting 2nd for loop, where we check if counter value is more than 2,
    // then we just know it is not prime, and move to next number
    //Almost similar Kind of big O(n square), there is difference but not something which I can quantify I guess
    static List<Integer> findPrimeNumberOptimizationOne(int size)
    {
        List<Integer> listOfPrimeNumbers = new ArrayList<>();
        for(int i = 1; i <= size; i++)
        {
            int counter = 0;
            for(int j = 1; j <= i; j++)
            {
                if (i%j == 0)
                {
                    counter++;
                }
                if (counter >=3)
                {
                    break;
                }
            }
            if(counter == 2)
            {
                listOfPrimeNumbers.add(i);
            }
        }
        return listOfPrimeNumbers;
    }

    //This method add optimization on top of above, where we cut the 2nd for loop with sqrt(number),
    // for which we need to find if the given number was prime or not
    static List<Integer> findPrimeNumberOptimizationTwo(int size)
    {
        List<Integer> listOfPrimeNumbers = new ArrayList<>();
        listOfPrimeNumbers.add(2);
        listOfPrimeNumbers.add(3);
        for(int i = 4; i <= size; i++)
        {
            int counter = 1;
            for(int j = 1; j * j <= i; j++)
            {
                if (i%j == 0)
                {
                    counter++;
                }
                if (counter >=3)
                {
                    break;
                }
            }
            if(counter == 2)
            {
                listOfPrimeNumbers.add(i);
            }
        }
        return listOfPrimeNumbers;
    }

    //Sieve Algorithm,
    //Big O(log(n))
    static List<Integer> findPrimeNumberOptimizationThree(int size)
    {
        boolean compositeNumberList[] = new boolean[size + 1];
        for(int i = 2; (i * i) <= size; i++)
        {
            if (compositeNumberList[i])
            {
                break;
            }
            for(int j = 2; i * j <= size; j++)
            {
                compositeNumberList[i * j] = true;
            }
        }
        List<Integer> integersList = new ArrayList<>();
        integersList.add(2);
        integersList.add(3);
        for (int i = 4; i < compositeNumberList.length; i++)
        {
            if (!compositeNumberList[i])
            {
                integersList.add(i);
            }
        }
        return integersList;
    }
}
