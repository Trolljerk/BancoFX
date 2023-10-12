package banco;

public class CDT extends Account {

	public CDT(int accnum) {

		super(accnum);

	}

	public void withdraw(double sum) {

		System.out.println("No es posible hacer retiros en una cuenta CDT.");

	}

	public double calcularRentabilidad(int dias) {

		return (this.getBalance() * 0.01) * dias + this.getBalance();

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

}
