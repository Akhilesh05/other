import scala.math._

class Quadratic(aa:Double, bb:Double, cc:Double){
	var a:Double = aa
	var b:Double = bb
	var c:Double = cc
	
	def solve():List[Double] = {
		var x1 = (-b+ sqrt(pow(b,2) - 4*a*c))/(2*a)
		var x2 = (-b- sqrt(pow(b,2) - 4*a*c))/(2*a)
		List(x1, x2)
	}
	
}

object Main {

   def main(args: Array[String]) {
   	    var x:Quadratic = new Quadratic(3,13,6)
        var y:List[Double] = (new Quadratic(2,8,4)).solve()
        println(y)
        println(x.a)
        println(x.solve)
   }
   
}
