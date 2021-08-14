//https://leetcode.com/problems/ugly-number/
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(9));
    }

    public static boolean isUgly(int n) {
        if (n < 1) {
            return false;
        } else if(n == 1 || n == 2 || n == 3 || n == 5)
        {
            return true;
        }

        int remainingValue = getDivideByTwo(getDivideByThree(getDivideByFive(n)));
        return remainingValue == 1;
    }

    public static int getDivideByTwo(int number)
    {
        if (number%2 == 0)
        {
            return getDivideByTwo(number/2);
        }
        return number;
    }

    public static int getDivideByThree(int number)
    {
        if (number%3 == 0)
        {
            return getDivideByThree(number/3);
        }
        return number;
    }

    public static int getDivideByFive(int number)
    {
        if (number%5 == 0)
        {
            return getDivideByFive(number/5);
        }
        return number;
    }
}
