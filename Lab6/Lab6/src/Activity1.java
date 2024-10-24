class Rectangle {
	double width, hight = 1.0;

	Rectangle() {
// TODO Auto-generated constructor stub
	}

	Rectangle(double newWidth, double newHight) {
		width = newWidth;
		hight = newHight;
	}

	double getArea() {
		return hight * width;
	}

	double getParimeter() {
		return (2 * hight) + (2 * width);
	}
}

public class Activity1 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(4, 40);
		Rectangle r2 = new Rectangle(3.5, 35.9);
		System.out.println("For the first rectangle :");
		System.out.println("The width = " + r1.width + "\nThe hight = " + r1.hight);
		System.out.println("The Area = " + r1.getArea());
		System.out.println("The Parimeter = " + r1.getParimeter() + "\n");
		System.out.println("For the second rectangle :");
		System.out.println("The width = " + r2.width + "\nThe hight = " + r2.hight);
		System.out.println("The Area = " + r2.getArea());
		System.out.println("The Parimeter = " + r2.getParimeter() + "\n");
	}
}