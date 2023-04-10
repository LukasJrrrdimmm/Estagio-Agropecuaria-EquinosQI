import java.util.*

open class Owner (val name:String, var age: Int, val cpf: String){
    fun birthday(){this.age++}
    val setAge = {age:Int -> this.age = age}
}
class HorseFunctionList{
    val horseFunctionList:List<String> = listOf("Cargueiro", "Fazendeiro", "Atleta", "Terapeuta", "Outro")
    fun getIndex(i:Int): String{
        return horseFunctionList.get(i)
    }
}

enum class HorseFunctions{
    DRAFT, FARM, SPORT, AID, OTHER;
}

public open class Horse(
    val name: String,
    val race:String,
    val sex:String,
    val castrated:Boolean,
    val age:Int,
    var owner:Owner
    ){
    private var horsefunc: HorseFunctions? = HorseFunctions.FARM
    private var birthdate: Date? = null

    fun sayHi(){
        println("Horse say: Neeigh!")
    }
    fun addBirthdate(date: Date){
        this.birthdate = date
    }
    fun newOwner(owner: Owner){
        this.owner = owner
    }
    fun changehorseFunction(numberFunc: Int){
        var horsefunc:String = ""
        try{
            horsefunc = HorseFunctionList().getIndex(numberFunc)
        }catch(e:Exception) {
            horsefunc = "Outro"
        }
        when(horsefunc){
            "Cargueiro" -> this.horsefunc = HorseFunctions.DRAFT
            "Fazendeiro" -> this.horsefunc = HorseFunctions.FARM
            "Atleta" -> this.horsefunc = HorseFunctions.SPORT
            "Terapeuta" -> this.horsefunc = HorseFunctions.AID
            else -> this.horsefunc = HorseFunctions.OTHER
        }
    }
    fun changehorseFunction(horsefunc: String){
        when(horsefunc){
            "Cargueiro" -> this.horsefunc = HorseFunctions.DRAFT
            "Fazendeiro" -> this.horsefunc = HorseFunctions.FARM
            "Atleta" -> this.horsefunc = HorseFunctions.SPORT
            "Terapeuta" -> this.horsefunc = HorseFunctions.AID
            else -> this.horsefunc = HorseFunctions.OTHER
        }
    }
    fun getHorseFunction(): String {
        when(this.horsefunc){
            HorseFunctions.DRAFT -> return "Cargueiro"
            HorseFunctions.FARM -> return "Fazendeiro"
            HorseFunctions.SPORT -> return "Atleta"
            HorseFunctions.AID -> return "Terapeuta"
            else -> return "Função Não Registrada"
        }
    }
}

class Test{
    private var id = 0
    fun runTest(): Double {
        this.id++
        val listA = listOf(1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 1)
        var score = 0
        for(i in listA){
            print("image = $i\n")
            print("1 or 2?\n")
            print("Entre Answer: ")
            val r: Int = (Scanner(System.`in`).next()).toInt()
            if(i == r) score++
        }
        return score.toDouble()/(listA.size).toDouble()
    }
    fun getId(): Int{
        return this.id
    }
}

class HorseSubject(subject: Horse) : Horse(
    name = subject.name,
    race = subject.race,
    sex = subject.sex,
    castrated = subject.castrated,
    age = subject.age,
    owner = subject.owner

){
    private var priorFeed:Boolean = false
    var score = 0.0
    fun fedHorse() {
        this.priorFeed = true
        println("Cavalo alimentado!")
    }

    fun makeTest(){
        val test = Test()
        this.score = test.runTest()
        println("Teste realizado com nota = ${this.score}")
    }
}

fun main(){
    var proprietario = Owner("Lukas Jardim", 27, "091.078.134-65")
    var myhorse = Horse("Corisco", "Quarto de Milha", "M", false, 5, proprietario)
    var testhorse = HorseSubject(myhorse)
    testhorse.sayHi()
    testhorse.fedHorse()
    testhorse.makeTest()
    testhorse.changehorseFunction(44)
    println(testhorse.getHorseFunction())

}