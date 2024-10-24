import java.util.Scanner;

public class Activity1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the number?");
		long a = scan.nextLong();
		int result = sumDigits(a);
		System.out.println("sum digits=" + result);

	}

	public static int sumDigits(long i) {
		int a = 0;
		for (; i > 0; i /= 10) {
			a += i % 10;
		}
		return a;

	}
}