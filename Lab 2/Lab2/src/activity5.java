import java.util.*;
public class activity5 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int x1,y1,x2,y2,Y,b,m,x;
		System.out.println("Enter the first x?");
		x1=input.nextInt();
		System.out.println("Enter the first y?");
		y1=input.nextInt();
		System.out.println("Enter the secound x?");
		x2=input.nextInt();
		System.out.println("Enter the secound y?");
		y2=input.nextInt();
		m=(y2-y1)/(x2-x1);
		b= y1-m*x1;
		x=x2-x1;
		Y= m*x+b;
		System.out.println("Y= " +""+ Y);

	}

}
