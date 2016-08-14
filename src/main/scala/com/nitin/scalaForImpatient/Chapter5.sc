class Employee {
}
class Manager extends Employee {
}

val e = new Manager
e.isInstanceOf[Manager] //res0: Boolean = true
e.asInstanceOf[Manager] //like [Manager]
e.getClass == classOf[Manager] //res2: Boolean = true

trait Logged {
  def log(msg: String) {}
}

trait ConsoleLogger extends Logged {
  override def log(msg: String) {println(msg)}
}

class SavingsAccount extends Logged {
  private var balance: Double = 0
  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient Funds")
    else balance -= amount
  }
}

val acct = new SavingsAccount with ConsoleLogger
acct.withdraw(1000)

trait TimeStampLogger extends Logged {
  override def log(msg: String) {
    super.log(new java.util.Date()) + " " + msg)
  }
}

