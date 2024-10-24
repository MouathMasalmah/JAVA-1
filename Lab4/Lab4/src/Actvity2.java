import java.util.Scanner;

public class Actvity2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the number?");
		int a = scan.nextInt();
		reverse(a);

	}

	public static void reverse(int i) {
		int a = 0;
		for (; i > 0; i /= 10) {

			a = (a + (i % 10)) * 10;
		}
		a = a / 10;
		System.out.println("reverse=" + a);

	}
}