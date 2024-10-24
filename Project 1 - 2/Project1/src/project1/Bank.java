package project1;

public class Bank {

	Account[] A1 = new Account[1000];
	int Index = 0;

	public Bank() {

	}

	public void addAccount(int id, String name, long phone, double balance, char choice) {
		if (Index < A1.length) {
			A1[Index] = new Account(id, name, phone, balance, choice);
			Index++;
		} else
			System.out.println(" The library has reached the maximum number of books ");

	}

	void addAmount(int id, String name, Double add) {
		int i = 0;
		while (A1[i] != null) {
			if (id == A1[i].getID() && name.equals(A1[i].getName())) {
				A1[i].setBalance(add + A1[i].getBalance());
				System.out.println(" the success deposite money the total money in your account " + A1[i].getBalance());
				break;
			}
			i++;
		}

		/*
		 * System.out.println("does't exit account "); break;
		 */

	}

	void displayAccounts(String name, int id) {

		int I = 0, count = 0;
		while (A1[I] != null) {
			if (A1[I].getName() == name && A1[I].getID() == id) {
				System.out.println("\nThe book: " + A1[I].toString());
				count++;
			}
			I++;
			if (count == 0) {
				System.out.println("\n erorr");

			}
		}

	}

	void withdrawAmount(int id2, String name2, Double balance2) {
		int i = 0;
		while (A1[i] != null) {

			if (id2 == A1[i].getID() && name2 == A1[i].getName()) {
				A1[i].setBalance(A1[i].getBalance() - balance2);
				System.out
						.println(" the success  withdraw  mony the total money in your account " + A1[i].getBalance());

			} else {
				System.out.println("no exist account ");
				break;
			}
			i++;

		}
		
	}
}
