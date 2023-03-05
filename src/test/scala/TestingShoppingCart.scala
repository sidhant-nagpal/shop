import org.scalatest.funspec.AnyFunSpec

class TestingShoppingCart extends AnyFunSpec {

  val cart = new ShoppingCart(List("Apple", "Apple", "Orange", "Orange", "Orange"));
  val demoItems: List[String] = List("Apple", "Apple", "Orange", "Orange", "Orange")

  describe("ShoppingCart"){

    it("should count the items correctly"){
      assert(cart.count == demoItems.length)
    }

    val appleCount: Int = demoItems.count(_.toLowerCase() == "apple")
    it("should be able to count apples"){
      assert(cart.appleCount() == appleCount)
    }

    val orangeCount: Int = demoItems.count(_.toLowerCase() == "orange")
    it("should be able to count oranges") {
      assert(cart.orangeCount() == orangeCount)
    }


    val appleOffer = (appleCount / 2) * 60
    val orangeOffer = (orangeCount / 3) * 25
    it("should calculate the total discount amount correctly"){
      assert(cart.discount == appleOffer + orangeOffer)
    }

    it("should calculate the total cost after discount at checkout"){
      val totalCost = appleCount*60 + orangeCount*25
      assert(cart.totalCost() == totalCost - (appleOffer+orangeOffer))
    }
  }
}


