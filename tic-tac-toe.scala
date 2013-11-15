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
	def win() {
		score += 1
		println(s"$name won the duel !!")
	}
	def lose() {
		println(s"$name !! Concentrate kiddo... :p")
	}
	def winGame() {
		println(s"$name won the Game !! Congrats...")
	}
	def loseGame() {
		println(s"Feelin' sorry for $name")
	}
}
object Grid
{
	private val sep:String = "-----------"
	val grid:String = s" a | b | c \n${sep}\n d | e | f \n${sep}\n g | h | i "

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
	
	def update():String = {
		"\n"+
		" " + (if(a == "o") "o" else if(a == "x") "x" else " ") + " |" +
		" " + (if(b == "o") "o" else if(b == "x") "x" else " ") + " |" +
		" " + (if(c == "o") "o" else if(c == "x") "x" else " ") + "   "+
		"     a | b | c \n" + s"$sep      $sep" + "\n" +
		" " + (if(d == "o") "o" else if(d == "x") "x" else " ") + " |" +
		" " + (if(e == "o") "o" else if(e == "x") "x" else " ") + " |" +
		" " + (if(f == "o") "o" else if(f == "x") "x" else " ") + "   "+
		"     d | e | f \n" + s"$sep      $sep" + "\n" +
		" " + (if(g == "o") "o" else if(g == "x") "x" else " ") + " |" +
		" " + (if(h == "o") "o" else if(h == "x") "x" else " ") + " |" +
		" " + (if(i == "o") "o" else if(i == "x") "x" else " ") + "   "+
		"     g | h | i \n"
		
	}
	
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
			case _ => false
		}
	}

	def checkWin(p1:Player=Game.player1, p2:Player=Game.player2) {

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
	var numDuel:Int = 0

	var turn:Player = Player()
	var player1:Player = Player()
	var player2:Player = Player()

	def init(p1:Player, p2:Player) {
		player1 = p1
		player2 = p2
		turn = p1
		win = false
		println("1: Lone Ranger(1 duel)\n2: Triple H(3 duels)\n3: 1 Bol 5(5 duel)\n4: Besharam(7 duels)\n")
		var type_ = readLine("Enter game type(1, 2, 3, or 4): ")
		numDuel = type_ match {
			case 1 => 1
			case 2 => 3
			case 3 => 5
			case 4 => 7
			case _ => 1
		}
	}
	def finish(){
		if(player1.score > player2.score)
			player1.winGame
		else
			player2.winGame
	}
	def winner(player:Player){
		win = true
		player.win
		if(player == player1) player2.lose else player1.lose
	}
	def toogleTurn() {
		if (turn == player1){
			turn = player2
		}else{
			turn = player1
		}
	}
}

object Main {
	def main(args: Array[String]){
		// ----- Players input their names -----
		var p1:Player = new Player(name=readLine("P1 name: "))
		var p2:Player = new Player(name=readLine("P2 name: "))

		// ----- Initiates the match
		for(1 to Game.numDuel){
		println(Grid.init(p1, p2))

		// ----- Gameplay -----
		while(!Game.win){
			while(!Game.turn.play){
				println("Invalid")
			}
			println(Grid.update)
			Grid.checkWin()
			Game.toogleTurn
		}
		}
		Game.finish
	}
}
