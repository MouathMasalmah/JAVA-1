

public class Activity6 {

	public static void main(String[] args) {
		int  b ;
		for(int i = 2 ; i < 10000 ; i++) {
			b = 0;
			for(int j = 1; j < i ; j++) {
				if (i%j == 0)
					b += j;
			}
			if (b == i) {
				System.out.println(i+" is perfect number");
			}
		}
		
	}
}
		