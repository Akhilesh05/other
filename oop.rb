class Point
	def initialize(x, y)
		@x, @y = x, y
	end
	def get_x
		@x
	end
	def get_y
		@y
	end
	def to_s
		"Pt(#@x, #@y)"
	end
end

class QuadraticEqt
	
	@@count = 0
	
	def initialize(a=0, b=0, c=0)
		@a, @b, @c = a.to_f, b.to_f, c.to_f
		@@count += 1
	end
	
	def get_a
		@a
	end
	
	def get_b
		@b
	end
	
	def get_c
		@c
	end
	
	def set_a=(a)
		@a = a
	end
	
	def set_b=(b)
		@b = b
	end
	
	def set_c=(c)
		@c = c
	end
	
	def solve
		x1 = (-@b+Math::sqrt(@b**2 - 4*@a*@c))/(2*@a)
		x2 = (-@b-Math::sqrt(@b**2 - 4*@a*@c))/(2*@a)
		Array[x1, x2]
	end
	
	def stationary
		x = -@b/(2*@a)
		y = @b**2/(4*@a) + @c
		Point.new(x, y)
	end
	
	def gradAt x
		2*@a*x + @b
	end
	
	def normalAt x
		-1 / gradAt(x)
	end
	
end

fx = QuadraticEqt.new 2, 8, 6

puts fx.solve
puts fx.normalAt fx.stationary.get_x

y = QuadraticEqt.new
y.set_a = 3
y.set_b = 15
y.set_c = 10

puts y.solve
puts y.stationary
