case class Player(
	val name:String = null,
	var score:Int = 0
)
{
	// MEthods here
	def play():Boolean = {
		var ox:String = null
		if(this == Game.player1) ox = "O" else ox = "X"
		var x:String = readLine(s"${name}!! Where to play ${ox}: ")
		Grid.checkAndPlace(this, x)
	}
	def win() = {
		println(s"${name} won !!!! Contrats !! :*")
	}
	def lose() = {
		
	}
}
object Grid
{
	private val sep:String = "-----------"
	val grid:String = s" A | B | C \n${sep}\n D | E | F \n${sep}\n G | H | I "

	def init(p1:Player, p2:Player):String = {
		Game.init(p1, p2)
		s"\n${p1.name} and ${p2.name} prepare yourselves for the DUEL !!\n\n$grid\n"
	}

	private var a:String = null
	private var b:String = null
	private var c:String = null
	private var d:String = null
	private var e:String = null
	private var f:String = null
	private var g:String = null
	private var h:String = null
	private var i:String = null
	def checkAndPlace(p:Player, x:String):Boolean = {
		x match{
			case "a" => if(a==null){
							if(Game.turn == Game.player1) a = "o" else a = "x"
							true
						}else{
							false
						}
			case "b" => if(b==null){
							if(Game.turn == Game.player1) b = "o" else b = "x"
							true
						}else{
							false
						}
			case "c" => if(c==null){
							if(Game.turn == Game.player1) c = "o" else c = "x"
							true
						}else{
							false
						}
			case "d" => if(d==null){
							if(Game.turn == Game.player1) d = "o" else d = "x"
							true
						}else{
							false
						}
			case "e" => if(e==null){
							if(Game.turn == Game.player1) e = "o" else e = "x"
							true
						}else{
							false
						}
			case "f" => if(f==null){
							if(Game.turn == Game.player1) f = "o" else f = "x"
							true
						}else{
							false
						}
			case "g" => if(g==null){
							if(Game.turn == Game.player1) g = "o" else g = "x"
							true
						}else{
							false
						}
			case "h" => if(h==null){
							if(Game.turn == Game.player1) h = "o" else h = "x"
							true
						}else{
							false
						}
			case "i" => if(i==null){
							if(Game.turn == Game.player1) i = "o" else i = "x"
							true
						}else{
							false
						}
		}
	}

	def checkWin(p1:Player, p2:Player) {

		if(a == b && a == c && a != null){
			a match {
				case "o" => Game.winner(p1)
				case "x" => Game.winner(p2)
			}
		}else if(d == e && d == f && d != null){
			d match {
                                case "o" => Game.winner(p1)
                                case "x" => Game.winner(p2)
			}
		}else if(g == h && g == i && g != null){
			g match {
                                case "o" => Game.winner(p1)
                                case "x" => Game.winner(p2)
			}
		}else if(a == d && a == g && a != null){
			a match {
                                case "o" => Game.winner(p1)
                                case "x" => Game.winner(p2)
			}
		}else if(b == e && b == h && b != null){
			b match {
                                case "o" => Game.winner(p1)
                                case "x" => Game.winner(p2)
			}
		}else if(c == f && c == i && c != null){
			c match {
                                case "o" => Game.winner(p1)
                                case "x" => Game.winner(p2)
			}
		}else if(a == e && a == i && a != null){
			a match {
                                case "o" => Game.winner(p1)
                                case "x" => Game.winner(p2)
			}
		}else if(c == e && c == g && c != null){
			c match {
                                case "o" => Game.winner(p1)
                                case "x" => Game.winner(p2)
			}
		}
		
	}
}
object Game
{
	var win:Boolean = false

	var turn:Player = Player()
	var player1:Player = Player()
	var player2:Player = Player()

	def init(p1:Player, p2:Player) = {
		player1 = p1
		player2 = p2
	}
	def winner(player:Player){
		win = true
		player.win
	}
	def toogleTurn(p1:Player, p2:Player) {
		if (turn == p1){
			turn = p2
		}else{
			turn = p1
		}
	}
}

object Main {
	def main(args: Array[String]){
		// ----- Players input their names -----
		var p1:Player = new Player(name=readLine("P1 name: "))
		var p2:Player = new Player(name=readLine("P2 name: "))

		// ----- Initiates the match
		println(Grid.init(p1, p2))

		// ----- Gameplay -----
		Game.win = false
		Game.turn = p1
		while(!Game.win){
			var x:Boolean = false
			while(!Game.turn.play){
				println("Invalid")
			}
			Grid.checkWin(p1, p2)
			Game.toogleTurn(p1, p2)
		}
	}
}
