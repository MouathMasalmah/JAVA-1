class RegularPolygon {
	int n = 5;
	double side = 2.0, x = 10.0, y = 10.0;

	RegularPolygon() {
	}

	RegularPolygon(int newN, double newSide) {
		n = newN;
		side = newSide;
	}

	RegularPolygon(int newN, double newSide, double newX, double newY) {
		n = newN;
		side = newSide;
		x = newX;
		y = newY;
	}

	double getPerimeter() {
		return n * side;
	}

	double getArea() {
		return (n * Math.pow(side, 2)) / (4 * Math.tan((Math.PI) / n));
	}
}

public class Activity3 {
	public static void main(String[] args) {
		RegularPolygon r1 = new RegularPolygon();
		RegularPolygon r2 = new RegularPolygon(4, 3);
		RegularPolygon r3 = new RegularPolygon(6, 4.5, 0, 0);
		System.out.println(
				"For the first Polygon: \nThe Area = " + r1.getArea() + " and The Perimeter = " + r1.getPerimeter());
		System.out.println(
				"For the second Polygon: \nThe Area = " + r2.getArea() + " and The Perimeter = " + r2.getPerimeter());
		System.out.println(
				"For the third Polygon: \nThe Area = " + r3.getArea() + " and The Perimeter = " + r3.getPerimeter());
	}
}