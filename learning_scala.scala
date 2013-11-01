object Main {

   def addInt(a:Int)(b:Int) : Int = {
   	a + b
   }
   
   def mult(a:Int, b:Int):Int = {
   	a * b
   }
   
   def main(args: Array[String]) {
      println(addInt(5){
          var x : Int = 3
          var y : Int = 2
          x + y
        }
      )
      println(mult(3,{
      	var x:Int = 2
      	var y:Int = 4
      	x * y
      }))
   }
}

// http://ideone.com/WhkGmj
