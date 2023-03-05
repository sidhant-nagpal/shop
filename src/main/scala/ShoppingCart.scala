import scala.annotation.tailrec

class ShoppingCart {

  val cart: List[String] = List()

  def isEmpty: Boolean = cart.isEmpty

  val appleCost: Int = 60
  val orangeCost: Int = 25

  def appleCount(): Int = cart.count(_.toLowerCase() == "apple")

  def orangeCount(): Int = cart.count(_.toLowerCase() == "orange")

  private def discount: Int = (this.appleCount / 2) * 60 + (this.orangeCount / 3) * 25

  @tailrec
  final def totalCost(accumulator: Int = 0, n: Int = 0): Float = {
    if (n >= cart.length) accumulator - discount
    else if (cart(n).toLowerCase() == "apple") totalCost(accumulator + appleCost, n + 1)
    else totalCost(accumulator + orangeCost, n + 1)
  }
}