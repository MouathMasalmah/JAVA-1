import java.util.*;
public class activity4 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int a,b,c,n;
		System.out.println("Enter the first number?");
		a=input.nextInt();
		System.out.println("Enter the secound number?");
		b=input.nextInt();
		System.out.println("Enter the third number?");
		c=input.nextInt();
		if(a>b+c || b>a+c || c>a+b) {
			n=a+b+c;
			System.out.println(n+""+"=the perimeter.");
		}
		else
			System.out.println("the input is invalid.");
		

	}

}
