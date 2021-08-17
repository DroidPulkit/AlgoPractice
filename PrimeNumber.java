import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    public static void main(String[] args) {
        //System.out.println(findPrimeNumberOptimizationThree(100000000));
        findPrimeNumberOptimizationThree(1);

        try {
            findPrimeNumberOptimizationThree(100000000);
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }


    //This is the brute force method
    //This method sucks as we add more and more zeros
    //Big O(n)
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
    //Big O(n)
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
    //Big O(sqrt(N))
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

    //This method add optimization on top of above, where we cut the 2nd for loop with sqrt(number),
    // for which we need to find if the given number was prime or not
    //Big O(sqrt(N))
    static List<Integer> findPrimeNumberOptimizationTwoMore(int size)
    {
        List<Integer> listOfPrimeNumbers = new ArrayList<>();
        listOfPrimeNumbers.add(2);
        listOfPrimeNumbers.add(3);
        for(int i = 4; i <= size; i++)
        {
            boolean addToList = true;
            //we know we already have 2 factors 1 and the number itself,
            // so any more factors will make it not prime
            for(int j = 2; j * j <= i; j++)
            {
                if (i%j == 0)
                {
                    addToList = false;
                    break;
                }
            }
            if(addToList)
            {
                listOfPrimeNumbers.add(i);
            }
        }
        return listOfPrimeNumbers;
    }

    //Sieve Algorithm,
    //Big O(log(n))
    static void findPrimeNumberOptimizationThree(int size)
    {
        //All boolean default value is false
        //we are assuming here, all integers are prime, and it starts from 2
        boolean[] compositeNumberList = new boolean[size - 1];
        //This for loop purpose is to determine the multiples of number starting from 2
        for(int i = 2; (i * i) <= size; i++)
        {
            if (compositeNumberList[i - 2])
            {
                continue;
            }
            //Here we find multiples and mark them as composite, but we start from
            // i * i position, as previous one have to be marked already
            for(int j = i; i * j <= size; j++)
            {
                compositeNumberList[(i * j) - 2] = true;
            }
        }
        //List<Integer> integersList = new ArrayList<>();
        int len = compositeNumberList.length;
        int counter = 0;
        for (int i = 0; i < len; i++)
        {
            if (!compositeNumberList[i])
            {
                ++counter;
                if (counter%100 == 1) System.out.print(i + 2 + "\n");
                //integersList.add(i + 2);
            }
        }
        //return integersList;
    }
}
