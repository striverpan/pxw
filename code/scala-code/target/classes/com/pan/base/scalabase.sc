(1 to 9).map("*" * _).foreach(println _)

(1 to 9).reduce((x1,x2) => x1+x2)

(1 to 9 ).reduceLeft((x1,x2) => x1*x2)

def getGreetingFunc(msg: String) = (name: String) => println(msg + ", " + name)
val greetingFuncHello = getGreetingFunc("hello")
val greetingFuncHi = getGreetingFunc("hi")








