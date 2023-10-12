package banco;

/**
 * @author Samir Conde 1152364
 * @author David Rincón 1152327
 * @author Juan David Ortiz Cano 1152298
 */
public class CurrentAccount extends Account {

	private double overdraftLimit;

	public CurrentAccount(int a) {
		super(a);
		this.overdraftLimit = 10;
	}

	@Override
	public void withdraw(double sum) {
		if (sum <= verifyOverdraftLimit()) {
			super.withdraw(sum);
		} else {
			System.err.println("Account.withdraw(...): " + "cannot withdraw if limit of overdraft is exceeded.");
		}
	}

	private double verifyOverdraftLimit() {
		return getBalance() + this.overdraftLimit;
	}

	public boolean OverdraftAccount() {
		return getBalance() < 0;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Account) {
			Account temp = (Account) obj;
			isEquals = this.getAccountNumber() == temp.getAccountNumber();
		}
		return isEquals;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

}
