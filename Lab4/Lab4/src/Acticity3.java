
public class Acticity3 {
public static void main(String[] args) {
	
for (int i = 2; i < 10000; i++) {
	boolean result=isPrime(i);
	if (result)
		System.out.println(i);
}

}
public static boolean isPrime(int n) {
	int count=0;
for (int i = 1; i <= n / 2; i++) {
if (n % i == 0)
count++;

}
if (count>1)
	return false;
	
return true;
}
}