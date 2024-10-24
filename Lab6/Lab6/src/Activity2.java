class Fan {
	int speed;
	boolean on;
	double radius = 5;
	String color = "blue";

	Fan() {
	}

public String toString() {
if (on == true){
return "The speed is " + speed + "\nThe color is " + color + "\nThe radius is " + radius;
}
else {
return "The color is " + color + "\nThe radius is " + radius + "\nFan is off";
}
}
}

public class Activity2 {
	public static void main(String[] args) {
		Fan f1 = new Fan();
		Fan f2 = new Fan();
		f1.speed = 100;
		f1.radius = 10;
		f1.color = "yellow";
		f1.on = true;
		f2.speed = 50;
		f2.radius = 5;
		f2.color = "blue";
		System.out.println("For the first Fan:\n" + f1.toString());
		System.out.println("For the second Fan:\n" + f2.toString());
	}
}