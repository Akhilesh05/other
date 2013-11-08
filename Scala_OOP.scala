import scala.math._

class QuadraticEqt(aa:Double=0, bb:Double=0, cc:Double=0){
	var a:Double = aa
	var b:Double = bb
	var c:Double = cc
	
	def yIntercept():Double = c
	
	def gradAt(x:Double):Double = 2*a*x + b
	
	def normalAt(x:Double):Double = -1 / gradAt(x)
	
	def solve():List[Double] = {
		var x1 = (-b+ sqrt(pow(b,2) - 4*a*c))/(2*a)
		var x2 = (-b- sqrt(pow(b,2) - 4*a*c))/(2*a)
		List(x1, x2)
	}
	
	def stationary():Map[String, Double] = {
		var x:Double = -b/(2*a)
		var y:Double = -pow(b,2)/(4*a) + c
		Map("x" -> x, "y" -> y)
	}
	
}

object Main {

   def main(args: Array[String]) {
   	    var x:QuadraticEqt = new QuadraticEqt(3,13,6)
   	    println(x.gradAt(x.stationary()("x")))  //equals zero everytime
   	    var y = (new QuadraticEqt(2,4,6)).stationary
   	    println(y)
   	    println(x.gradAt(3))
   	    println(x.normalAt(3))
   	    println(x.yIntercept)
   }
   
}
