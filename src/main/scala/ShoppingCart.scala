import scala.annotation.tailrec

class ShoppingCart {

  val cart: List[String] = List()

  def isEmpty: Boolean = cart.isEmpty

  val appleCost: Int = 60
  val orangeCost: Int = 25

  @tailrec
  final def totalCost(accumulator: Int = 0, n: Int = 0): Float = {
    if (n >= cart.length) accumulator
    else if (cart(n).toLowerCase() == "apple") totalCost(accumulator + appleCost, n + 1)
    else totalCost(accumulator + orangeCost, n + 1)
  }
}