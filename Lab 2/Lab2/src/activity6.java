import java.util.*;
public class activity6 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		float exchange,n,rate;
		int a;
		System.out.println("Enter the exchange rate from $ to JOD:");
		rate=input.nextFloat();
		System.out.println("Enter 0 to convert $ to JOD and 1 vice versa:");
		a=input.nextInt();
		if(a==0) {
		System.out.println("Enter the $ amount:");
		n=input.nextFloat();
		exchange= n*rate;
		System.out.println(n +""+ "$ is " +""+ exchange+ ""+ "JOD");
		}
		else if(a==1) {
			System.out.println("Enter the JOD amount:");
			n=input.nextFloat();
			exchange=n/rate;
			System.out.println(n+""+ "JOD is " +""+ exchange +""+ "$");
		}
		else 
			System.out.println("Incorrect input:" +""+ a);	
	}

}