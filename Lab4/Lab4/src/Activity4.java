import java.util.Scanner;

public class Activity4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of sides:");
		int n = scan.nextInt();
		
		System.out.println("Enter the side:");
		double s = scan.nextDouble();
		
		double result = Area(n,s);
		System.out.println("The area of the polygon is:" + result);

	}

	public static double Area(int n,double s) {
		double Area=((n*Math.pow(s,2))/(4*Math.tan(3.14/n)));
		return Area;

	}
}