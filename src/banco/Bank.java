package banco;

import java.util.ArrayList;

/**
 * @author Samir Conde 1152364
 * @author David Rincón 1152327
 * @author Juan David Ortiz Cano 1152298
 */

public class Bank {

	private ArrayList<Account> clientsAccount;

	private static Bank instance;

	private Bank() {

		this.clientsAccount = new ArrayList<>();

	}

	public static Bank getInstance() {

		if (instance == null) {
			instance = new Bank();
			System.out.println("Instantiated bank class.");
		}
		return instance;

	}

	public double getBalance(int accnum) {

		int position;
		double balance = 0.0;

		Account tempAccount = new Account(accnum);

		position = searchAccount(tempAccount);

		if (position != -1) {

			balance = this.clientsAccount.get(position).getBalance();

		} else {

			System.err.println("The account number entered is not affiliated with an existing account.");

		}

		return balance;

	}

	public void payDividend(int accnum, double amount) {

		int position;
		Account tempAccount = new Account(accnum);

		position = searchAccount(tempAccount);

		if (position != -1) {

			this.clientsAccount.get(position).deposit(amount);

		} else {

			System.err.println("The account number entered is not affiliated with an existing account.");

		}

	}

	public void withdrawAccount(int accnum, double amount) {

		int position;
		Account tempAccount = new Account(accnum);

		position = searchAccount(tempAccount);

		if (position != -1) {

			this.clientsAccount.get(position).withdraw(amount);

		} else {

			System.err.println("The account number entered is not affiliated with an existing account.");

		}

	}

	public boolean openAccount(char accountType, int accnum) {

		int position;
		boolean wasAdded = false;
		Account newAccount = null;

		if (accountType == 'C') {
			newAccount = new CurrentAccount(accnum);
		} else if (accountType == 'A') {
			newAccount = new SavingsAccount(accnum);
		} else if (accountType == 'D') {
			newAccount = new CDT(accnum);
		}

		position = searchAccount(newAccount);

		if (position == -1) {
			wasAdded = this.clientsAccount.add(newAccount);
		} else {
			System.err.println("The account with those credentials already exists.");
		}

		return wasAdded;

	}

	public boolean closeAccount(int accnum) {

		int position;
		boolean wasRemoved = false;

		Account tempAccount = new Account(accnum);
		position = searchAccount(tempAccount);

		if (position != -1) {
			this.clientsAccount.remove(position);
			wasRemoved = true;
		} else {
			System.err.println("The account number entered is not affiliated with an existing account.");
		}

		return wasRemoved;

	}

	private int searchAccount(Account account) {

		try {

			int index = -1;

			for (int i = 0; (i < this.clientsAccount.size()) && (index == -1); i++) {

				if (this.clientsAccount.get(i).equals(account)) {

					index = i;

				}

			}

			return index;

		} catch (Exception e) {

			throw new RuntimeException("Ha ocurrido un error, por favor comuniquese con el soporte tecnico del banco.");

		}

	}

	public void sendLetterToOverdraftAccounts() {

		for (Account a : getClientsAccount()) {

			if (a instanceof CurrentAccount) {
				CurrentAccount ca = (CurrentAccount) a;
				if (ca.OverdraftAccount()) {

					System.out.println("Sending letter to this " + ca.getAccountNumber() + " account");

				}

			}

		}

	}

	public void rentabilidadCuentasCDT(int dias) {

		for (Account a : getClientsAccount()) {

			if (a instanceof CDT cdt) {
				System.out.println("Account " + cdt.getAccountNumber() + " - Rentabilidad estimada: "
						+ cdt.calcularRentabilidad(dias));
			}

		}

	}

	public ArrayList<Account> getClientsAccount() {
		return clientsAccount;
	}

	public void setClientsAccount(ArrayList<Account> clientsAccount) {
		this.clientsAccount = clientsAccount;
	}

}
