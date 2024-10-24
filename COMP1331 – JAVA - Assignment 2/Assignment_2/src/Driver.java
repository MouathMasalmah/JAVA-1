//Mouath Sami Masalmah,1220179,section: 11,section lab: 6,D. Saadeddin Hroub.
public class Driver {

	public static void main(String[] args) {
		Library library = new Library(); // Definition of an object through which we can save books in the library class

		// We put the name of the Object [library], then a dot, then the name of the
		// method through which books are entered into the system   [newBook]
		library.newBook("Computer security", "Matt Bishop", 2, "Addison-Wesley Professional", "English");
		library.newBook("Computer science", "Mohammad hadi", 3, "Scientific institution for publishing", "English");
		library.newBook("يسألونك ", "Prof Hosam Aldeen Afana", 10, "دار الطيب للطباعة والنشر", "Arabic");
		library.newBook("مختصر صحيح مسلم", "Ahmad Shams Aldeen", 1, "دار الكتب العلمية - بيروت", "Arabic");
		library.newBook("الوجيز في تاريخ الإسلام والمسلمين", "Prof Ameer Abdalaziz", 2, "Addison-Wesley Professional","Arabic");
		library.newBook("Linux From Scratch", "Gerard Beckmans", 11, "Addison-Wesley Professional", "English");
		library.newBook("رجال حول الرسول", "Khaled Mohammad Khaled", 1, "دار الفكر للطباعة والنشر والتوزيع", "Arabic");
		library.newBook("الوجيز في فقه السنة والكتاب العزيز", "Abd Alazeem Ben Badwa ", 2, "شركة النور للطباعة والنشر والتوزيع", "Arabic");
		library.newBook("تاريخ الأدب العربي","D.Omar Farrokh", 1, "دار العام للملايين", "Arabic");
		library.newBook("How to write complex code", "Mouath Sami Masalmah", 7, "Addison-Wesley Professional", "English");

		library.borrowBook("الوجيز في تاريخ الإسلام والمسلمين");// Request to borrow a book
		
		library.borrowBook("Linux From Scratch");// Request to borrow a book
		
		library.borrowBook("الوجيز في تاريخ الإسلام والمسلمين");// Request to borrow a borrowed book
		
		library.returnBook("Linux From Scratch");// Return a borrowed book
		
		library.printAvailableBooks();// We put the name of the Object     [library], then a dot, then the name of the
										// method through which we can print all available (non-borrowed) books. [newBook]
	}

}
