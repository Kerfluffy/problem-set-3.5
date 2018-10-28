/**
 * INSTRUCTIONS.
 * 
 * The following exercises are, perhaps, more mathematically inclined than previous
 * problem sets. While they might be challenging, they are certainly doable.
 * 
 * You can (and should!) solve each of them using only the operators, conditional control
 * structures, and iterative control structures we've covered. You are not permitted to use
 * recursive code in your solutions.
 * 
 * Please be mindful of the expected outputs, as your code will be tested against that
 * directly. If you're unsure, please ask for clarification.
 * 
 * This problem set is worth 25 points and is due no later than 11:59pm on October 28, 2018.
 */

public class ProblemSet3_5 {
	
	/**
	 * Main method where you should test your code.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		ProblemSet3_5 ps = new ProblemSet3_5();
		
		ps.primes(1, 10000);
		ps.leapYears(3);
		ps.palindromicNumbers(5);
		ps.fibonacci(4);
		ps.multiples(4, 8, 12);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * How many prime numbers are there between @start and @end, where @start and @end
	 * are positive integers in the range [1, @Integer.MAX_VALUE]?
	 * 
	 * Print your solution in the following formats: "There is X prime number."
	 *                                               "There are X prime numbers."
	 * 
	 * @param start
	 * @param end
	 */
	
	public void primes(int start, int end) {
		int prime_amount = 0;
		for (int i = start; i <= end; i++) {
			int factors = 0;
            int nums = 1;

            while(nums <= i)
            {
                if(i % nums == 0)
                {
                    factors++;
                }
                nums++;
            }
            if (factors == 2)
            {
                prime_amount++;
            }
		}
		if (prime_amount == 1) 
		{
			System.out.println("There is " + prime_amount + " prime number.");
		}
		else if (prime_amount > 1)
		{
			System.out.println("There are " + prime_amount + " prime numbers.");
		}
		else
		{
			System.out.println("There are no prime numbers.");
		}
	}
	
	/**
	 * What are the next @count leap years?
	 * 
	 * Print your solution in the following formats: "The next leap year is X."
	 *                                               "The next 2 leap years are X and Y."
	 *                                               "THe next N leap years are A, ..., X, Y, and Z."
	 * 
	 * @param count
	 */
	
	public void leapYears(int count) {
		int current_year = 2018;
		int amount = 0;
		
		if (count == 1) {
			System.out.print("The next leap year is ");
			while (amount < count) {
				
				if ((current_year % 4 == 0) && (current_year % 100 != 0) || (current_year % 400 == 0)) {
					System.out.print(current_year);
					current_year++;
					amount++;
				}
				else if ((current_year % 4 != 0) && (current_year % 100 == 0) || (current_year % 400 != 0)) {
					current_year++;
				}
			
		}
		}
		else if (count == 2) {
			System.out.print("The next 2 leap years are ");
			while (amount < count) {
				
				if ((current_year % 4 == 0) && (current_year % 100 != 0) || (current_year % 400 == 0)) {
					if (amount == (count - 1)) {
						System.out.println(current_year + ".");
						current_year++;
						amount++;
					}
					else {
						System.out.print(current_year +  " and ");
						current_year++;
						amount++;
					}
				}
				else if ((current_year % 4 != 0) && (current_year % 100 == 0) || (current_year % 400 != 0)) {
					current_year++;
				}
			
			}
		}
		else {
			System.out.print("The next " + count +  " leap years are ");
			while (amount < count) {
				
				if ((current_year % 4 == 0) && (current_year % 100 != 0) || (current_year % 400 == 0)) {
					if (amount == (count - 1)) {	
						System.out.println("and " + current_year + ".");
						current_year++;
						amount++;
					}
					else {
						System.out.print(current_year + ", ");
						current_year++;
						amount++;
						
					}
				}
				else if ((current_year % 4 != 0) && (current_year % 100 == 0) || (current_year % 400 != 0)) {
					current_year++;
				}
			
			}
		}		
		
	}
	
	/**
	 * Is @number a palindromic number?
	 * 
	 * Print your solution in the following formats: "X is a palindromic number."
	 *                                               "X is not a palindromic number."
	 *                                               
	 * @param number
	 */
	
	public void palindromicNumbers(int number) {
		boolean palindromic = true;
		
		int length = (int)(Math.log10(number)+1);
		int i = 0;
		
			while (i < length && palindromic) {
				if ( (int) (number / Math.pow(10,length - (i + 1)) % 10) == (int) (number / Math.pow(10,i)) % 10);
				else palindromic = false;
				i++;
		}
			System.out.println(number + " is" + ((palindromic) ? "" : " not") + " a palindromic number");
	}
	
	/**
	 * What is the @nth Fibonacci number, where @n is a positive integer?
	 * 
	 * Print your solution in the following formats: "The 21st Fibonacci number is X."
	 *                                               "The 22nd Fibonacci number is X."
	 *                                               "The 23rd Fibonacci number is X."
	 *                                               "The 24th Fibonacci number is X."
	 *                                               
	 * @param n
	 */
	
	public void fibonacci(int n) {
		int num1 = 1;
		int num2 = 1;
		if (n == 1) {
			System.out.println("The 1st Fibonacci number is 1.");
		}
		else if (n == 2) {
			System.out.println("The 2nd Fibonacci number is 1.");
		}
		else {
			
			for (int i = 2; i < n; i++) {
				int temp = num2;
				num2 += num1;
				num1 = temp;	
			}
			
			if (n % 100 > 10 && n % 100 < 20) {
				System.out.println("The " + n + "th Fibonacci number is " + num2 + ".");
			}
			
			else {
				switch(n % 10) {
				case 1:
					System.out.println("The " + n + "st Fibonacci number is " + num2 + ".");
					break;
				case 2:
					System.out.println("The " + n + "nd Fibonacci number is " + num2 + ".");
					break;
				case 3:
					System.out.println("The " + n + "rd Fibonacci number is " + num2 + ".");
					break;
				default:
					System.out.println("The " + n + "th Fibonacci number is " + num2 + ".");
					break;
				}
				
			}
			
		}
	}
	
	/**
	 * What is the sum of all multiples of @x and @y less than @limit, where @x, @y, and
	 * @limit are positive integers?
	 * 
	 * Print your solution in the following format: "The sum of all multiples of X and Y less than LIMIT is Z."
	 * 
	 * @param limit
	 */
	
	public void multiples(int x, int y, int limit) {
		long sum = 0;
		for (int i = 0; i < limit; i++) {
			sum += (i % x == 0 || i % y == 0) ? i : 0;
		}
		System.out.println("The sum of all multiples of " + x + " and " + y + " less than " + limit + " is " + sum + ".");
		}
	}
