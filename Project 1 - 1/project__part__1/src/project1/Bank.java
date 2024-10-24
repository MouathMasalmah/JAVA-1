
package project1;

import java.io.*;
import java.util.*;

public class Bank {
	static int AccountCounter = 0;
	File file = new File("Account.txt");
	Scanner scan = new Scanner(System.in);

	static Account[] account = new Account[9000];
	Account A = new Account();

	public Bank() {

	}

	boolean addAccount(Account a) {
		int count = 0;
		for (int i = 0; i < account.length; i++) {
			if (account[i] == null) {
				account[i] = a;
				count++;
				AccountCounter++;
				break;
			}
		}
		if (count == 0) {
			return false;
		}
		return true;
	}

	void displayAccounts() {
		for (int i = 0; i < account.length; i++) {
			if (account[i] == null) {
				continue;
			} else {
				System.out.println(account[i].toString());
			}
		}
	}

	Account viewAccountDetails(int options) {
		switch (options) {
		case 1:
			int Id = 0;
			boolean validInput = false;
			while (!validInput) {
				try {
					if (Id > 9999 || Id <= 999 || Id == 0) {
						System.out.println("Please enter ID [ 4-digit number ]:");
						Id = scan.nextInt();
					} else {
						validInput = true;
					}
				} catch (InputMismatchException ex) {
					System.out.println("Error: Please enter a valid number.");
					scan.next();
				}
			}
			int i = 0;
			int count = 0;
			while (account[i] != null) {
				if (account[i].getID() == Id) {
					A = account[i];
					count++;
					break;
				}
				i++;
			}

			if (count == 0) {
				return null;
			}
			break;
		case 2:
			String Name = null;
			validInput = false;
			A = null;

			Name = scan.nextLine();
			do {
				try {
					System.out.println("Enter your name, without spaces:");
					Name = scan.nextLine();
					if (Name.contains(" ")) {
						System.out.println("Error: Please enter a name without spaces.");
					} else {
						validInput = true;
					}
				} catch (NoSuchElementException ex) {
					System.out.println("Error: Please enter a valid name (without spaces).");
					scan.nextLine(); // Clear invalid input from the scanner
				}
			} while (!validInput);
			i = 0;
			count = 0;
			while (account[i] != null) {
				if (account[i].getName().contains(Name)) {
					A = account[i];
					count++;
					System.out.println(A.toString());
				}
			}
			if (count == 0) {
				return null;
			}
			break;
		}
		return A;
	}

	boolean closeAccount(Account a) {
		int AccountCounter2 = AccountCounter - 1;
		int i = 0;
		int count = 0;
		while (account[i] != null) {
			if (account[i] == a) {
				account[i] = account[AccountCounter2];
				account[AccountCounter2] = null;
				AccountCounter--;
				count++;
				break;
			}
			i++;
		}
		if (count == 0) {
			return false;
		}
		return true;

	}

	void modifyAccountDetails(int options) {
		switch (options) {
		case 1:
			int id = 0;
			int count = 0;
			boolean validInput = false;
			do {
				try {
					if (id <= 0) {
						System.out.println("Enter your ID:");
						id = scan.nextInt();
					} else {
						validInput = true;
					}
				} catch (InputMismatchException ex) {
					System.out.println("Error, please enter a valid number:");
					scan.next();
				}
			} while (!validInput);
			int i = 0;
			while (account[i] != null) {
				if (account[i].getID() == id) {
					System.out.println("\n" + "1- name\n" + "2- ID\n" + "3- Phone number\n" + "4- Account type");
					int Options = 0;
					validInput = false;
					do {
						try {
							if (Options < 1 || Options > 4) {
								System.out.println("Enter the number of the option you want to modify:");
								Options = scan.nextInt();
							} else {
								validInput = true;
							}
						} catch (InputMismatchException ex) {
							System.out.println("Error, please enter a valid number:");
							scan.next();
						}
					} while (!validInput);
					switch (Options) {
					case 1:
						int hasSpace = 0;
						String Name = "";
						do {

							for (i = 0; i < Name.length(); i++) {
								if (Name.charAt(i) == ' ' || Character.isDigit(Name.charAt(i))) {

									hasSpace++;
									break;
								} else if (Name.charAt(i) == '_') {
									continue;
								}
							}

							if (hasSpace == 1) {
								System.out.println("Error: Please enter a name without spaces or number:");
							} else {
								count++;
								account[i].setName(Name);
								break;
							}

						} while (hasSpace != 0);

						break;
					case 2:

						for (i = 0; i < Bank.account.length; i++) {
							if (Bank.account[i] != null) {
								if (id == Bank.account[i].getID()) {

									id = 0;
									validInput = false;

									do {
										try {
											System.out.println("Please enter a new ID [ 4-digit number ]:");
											id = scan.nextInt();
											if (id == Bank.account[i].getID()) {
												System.out.println(
														"The number you entered already exists, enter another number:");
											} else if (id > 9999 || id <= 999) {
												System.out.println("Error: Please enter a 4-digit number.");
											} else {
												account[i].setID(id);
												count++;
												validInput = true;
												break;
											}
										} catch (InputMismatchException ex) {
											System.out.println("Error: Please enter a valid number.");
											scan.next();
										}
									} while (!validInput);
								} else if (count > 0) {

									break;
								}
							}
						}
						break;
					case 3:

						int phone = 0;
						validInput = false;
						do {
							try {
								if (phone <= 0) {
									System.out.println("\nEnter the new Phone number please:");
									phone = scan.nextInt();
								} else {
									count++;
									account[i].setPhone(phone);
									validInput = true;
								}
							} catch (InputMismatchException ex) {
								System.out.println("Error, please enter a valid number:");
								scan.next();
							}
						} while (!validInput);

						break;
					case 4:

						char AccountType = 0;
						char save = 's';
						char other = 'o';
						validInput = false;
						do {

							try {
								System.out.println("Enter the new Account type please[s --> saving and o --> others]:");
								AccountType = scan.nextLine().charAt(0);
								if (AccountType != save && AccountType != other) {
									System.out.println(
											"The character you entered is wrong, please enter a valid character:");
								} else if (AccountType == save || AccountType == other) {
									count++;
									account[i].setChoice(AccountType);
									validInput = true;
								}
							} catch (InputMismatchException ex) {
								System.out.println("Error, please enter a valid character:");
								scan.nextLine();
							}
						} while (!validInput);

						break;
					default:
						System.out.println("Error,enter a number in the options:");
						options = 0;
						validInput = false;
						do {
							try {
								if (options <= 0) {
									options = scan.nextInt();
								} else {
									validInput = true;
								}
							} catch (InputMismatchException ex) {
								System.out.println("Error, please enter a valid number:");
								scan.next();

							}
						} while (!validInput);

					}
				}
				i++;
			}
			if (count == 0) {
				System.out.println("Sorry, your account does not exist :( ");
			} else {
				System.out.println("operation accomplished successfully :) ");
			}
			break;
		case 2:
			id = 0;
			count = 0;
			validInput = false;
			do {
				try {
					if (id <= 0) {
						System.out.println("Enter your ID:");
						id = scan.nextInt();
					} else {
						validInput = true;
					}
				} catch (InputMismatchException ex) {
					System.out.println("Error, please enter a valid number:");
					scan.next();
				}
			} while (!validInput);
			i = 0;
			while (account[i] != null) {
				if (account[i].getID() == id) {
					System.out.println("\n" + "1- name\n" + "2- ID\n" + "3- Phone number\n" + "4- Account type");
					int Options = 0;
					validInput = false;
					do {
						try {
							if (Options <= 0 || Options > 4) {
								System.out.println("Enter the number of the option you want to modify:");
								Options = scan.nextInt();
							} else {
								validInput = true;
							}
						} catch (InputMismatchException ex) {
							System.out.println("Error, please enter a valid number:");
							Options = scan.nextInt();
						}
					} while (validInput);
					switch (Options) {
					case 1:
						int hasSpace = 0;
						String name = "";
						do {

							for (i = 0; i < name.length(); i++) {
								if (name.charAt(i) == ' ' || Character.isDigit(name.charAt(i))) {
									hasSpace++;
									break;
								} else if (name.charAt(i) == '_') {
									continue;
								}
							}

							if (hasSpace == 1) {
								System.out.println("Error: Please enter a name without spaces or number:");
							} else {
								count++;
								account[i].setName(name);
								break;
							}

						} while (hasSpace != 0);

						break;
					case 2:

						for (i = 0; i < Bank.account.length; i++) {
							if (Bank.account[i] != null) {
								if (id == Bank.account[i].getID()) {

									id = 0;
									validInput = false;

									do {
										try {
											System.out.println("Please enter a new Id [ 4-digit number ]:");
											id = scan.nextInt();
											if (id == Bank.account[i].getID()) {
												System.out.println(
														"The number you entered already exists, enter another number:");
											} else if (id > 9999 || id <= 999) {
												System.out.println("Error: Please enter a 4-digit number.");
											} else {
												count++;
												account[i].setID(id);
												validInput = true;
											}
										} catch (InputMismatchException ex) {
											System.out.println("Error: Please enter a valid number.");
											scan.next();
										}
									} while (!validInput);
								}
							}
						}
						break;
					case 3:

						int phone = 0;
						validInput = false;
						do {
							try {
								if (phone <= 0) {
									System.out.println("Enter the new Phone number please:");
									phone = scan.nextInt();
								} else {
									account[i].setPhone(phone);
									count++;
									validInput = true;
								}
							} catch (InputMismatchException ex) {
								System.out.println("Error, please enter a valid number:");
								scan.next();
							}
						} while (!validInput);

						break;
					case 4:

						char AccountType = 0;
						char save = 's';
						char other = 'o';
						validInput = false;
						do {
							System.out.println("Enter the new Account type please[s --> saving and o --> others]:");
							try {
								AccountType = scan.nextLine().charAt(0);
								if (AccountType != save && AccountType != other) {
									System.out.println(
											"The character you entered is wrong, please enter a valid character:");
								} else if (AccountType == save || AccountType == other) {
									count++;
									account[i].setChoice(AccountType);
									validInput = true;
								}
							} catch (InputMismatchException ex) {
								System.out.println("Error, please enter a valid character:");
								scan.nextLine();
							}
						} while (!validInput);

						break;
					default:
						System.out.println("Error,enter a number in the options:");
						options = 0;
						validInput = false;
						do {
							try {
								if (options <= 0) {
									options = scan.nextInt();
								} else {
									validInput = true;
								}
							} catch (InputMismatchException ex) {
								System.out.println("Error, please enter a valid number:");
								scan.next();

							}
						} while (!validInput);

					}
				}
				if (count == 0) {
					System.out.println("Sorry, your account does not exist :( ");
				} else {
					System.out.println("operation accomplished successfully :) ");
				}
				i++;
			}
		}
	}

	void addAmount(Double add) {
		System.out.println("Enter the new ID please:");
		int Id = 0;
		int count = 0;
		boolean validInput = false;
		do {
			try {
				Id = scan.nextInt();
				if (Id > 9999 || Id <= 999) {
					System.out.println("Error: Please enter a 4-digit number.");
				} else {
					validInput = true;
				}
			} catch (InputMismatchException ex) {
				System.out.println("Error: Please enter a valid number.");
				Id = scan.nextInt(); // Clear invalid input from the scanner
			}
		} while (!validInput);
		int i = 0; /* the index for the array for test the array equal null or not */
		while (account[i] != null) { /*
										 * when the array don't null values get parameter value (the money want deposit
										 * ) add for total balance and save sum total balance
										 */
			if (account[i].getID() == Id) {

				account[i].setBalance(add + account[i].getBalance());
				System.out.println(
						" the success deposite money the total money in your account: " + account[i].getBalance());
				count++;
				break;
			}
			i++;
		}
		if (count != 0) {
			System.out.println("Operation accomplished successfully");
		} else {
			System.out.println("Operation failed, try again");
		}
	}

	boolean withdrawAmount(Double Deduction) {
		System.out.println("Enter the new ID please:");
		int Id = 0;
		boolean validInput = false;
		do {
			try {
				Id = scan.nextInt();
				if (Id > 9999 || Id <= 999) {
					System.out.println("Error: Please enter a 4-digit number.");
				} else {
					validInput = true;
				}
			} catch (InputMismatchException ex) {
				System.out.println("Error: Please enter a valid number.");
				scan.next(); // Clear invalid input from the scanner
			}
		} while (!validInput);
		int i = 0;
		while (account[i] != null) {
			if (account[i].getID() == Id) {
				/*
				 * when the array don't null values get parameter value (the money want withdraw
				 * ) discount for total balance and save sum total balance
				 */
				if (Deduction > account[i].getBalance() || account[i].getBalance() == 0) {
					/*
					 * Using the if condition to check the amount he wants to withdraw if it is
					 * greater than the total balance and if the total balance is zero
					 */

					if (Deduction > account[i].getBalance()) {
						/*
						 * Use the if condition to check the amount you want to withdraw if it is
						 * greater than the total balance prints try again
						 */
						System.out.println("The number you entered is greater than your balance, try again!");
					} else if (account[i].getBalance() == 0) {

						/*
						 * Use an if condition to check if the total balance is zero print The account
						 * has no balance
						 */

						System.out.println("The account has no balance!!");

					}
					return false;
				}

				else if (account[i].getBalance() >= Deduction) {
					/*
					 * get parameter value (the money want withdraw ) discount for total balance and
					 * save sum total balance if total balance greater than or equal the money want
					 * withdraw
					 */
					if (account[i].getAccountType() == 's' && Deduction > 500) {
						System.out.println("Sorry, your account type does not allow you to withdraw more than 500 ");
						return false;
					} else {
						account[i].setBalance(account[i].getBalance() - Deduction);
						System.out.println("The success  withdraw  mony the total money in your account "
								+ account[i].getBalance());

					}
				}

			}
			i++;
		}

		return true;
	}

	public static boolean uploadDataFile() {
		try {
			File file = new File("Account.txt");
			Scanner upload = new Scanner(file);
			Account account = new Account();
			int i = 0;
			while (upload.hasNextLine()) {
				String line = upload.nextLine();
				String[] data = line.split(", ");

				int id = Integer.parseInt(data[0]);
				String name = data[1];
				int phone = Integer.parseInt(data[2]);
				char accountType = data[3].charAt(0);
				double balance = Double.parseDouble(data[4]);
				account = new Account(id, name, phone, balance, accountType);
				Bank.account[i] = account;
				i++;
				AccountCounter++;

			}

			upload.close();
			return true;
		} catch (IOException e) {
			System.out.println(e);
			return false;
		}

	}

	public boolean updateDataFile() {
		int i = 0;
		boolean validInput = false;
		do {
			try {
				PrintWriter SaveUpdate = new PrintWriter(file);
				while (account[i] != null) {

					SaveUpdate.print(account[i].getID() + ", ");
					SaveUpdate.print(account[i].getName() + ", ");
					SaveUpdate.print(account[i].getPhone() + ", ");
					SaveUpdate.print(account[i].getAccountType() + ", ");
					SaveUpdate.print(account[i].getBalance() + "\n");
					i++;
				}
				SaveUpdate.close();
				validInput = true;

			} catch (IOException ex) {
				return false;
			}
		} while (!validInput);
		return true;
	}

}
