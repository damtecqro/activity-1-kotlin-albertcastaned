package com.example.myapplication


// ACTIVITY 1
// AUTHOR: Alberto Castañeda Arana A01250546
// PROBLEMS SOLVED: P6, P36


fun isPalindrome(nums: List<Int>) : Boolean
{
    var lowIndex = 0
    var highIndex = nums.size - 1

    val mid: Int = highIndex / 2

    for(num in nums)
    {
        if(lowIndex > mid)
            break

        if(nums[lowIndex] != nums[highIndex])
            return false

        lowIndex += 1
        highIndex -= 1

    }

    return true

}

fun Int.isPrime(): Boolean
{
    if (this <= 1)
        return false

    var i = 2

    while(i < this)
    {
        if(this % i == 0)
            return false

        i+=1
    }

    return true
}

fun Int.primeFactors(): List<Int>
{
    if (this.isPrime())
        return listOf(this)

    val primeFactor = (2..(this / 2)).filter { it.isPrime() }.find { this % it == 0 }

    if (primeFactor == null)
        return emptyList()
    else
        return listOf(primeFactor) + (this / primeFactor).primeFactors()
}

fun Int.primeFactorMultiplicity(): List<Pair<Int, Int>>
{
    return this.primeFactors().groupBy { it }.map { Pair(it.key, it.value.size) }
}


var testIndex = 1

fun assertEquals(firstValue: Boolean, secondValue: Boolean)
{
    if(firstValue == secondValue)
        println("Prueba #" + testIndex + " ha pasado")
    else
        println("Prueba #" + testIndex + " no ha pasado")

    testIndex += 1
}

// P06

//Pruebas de GITHUB
assertEquals(isPalindrome(listOf<Int>()), true)
assertEquals(isPalindrome(listOf(1)), true)
assertEquals(isPalindrome(listOf(1, 2)), false)
assertEquals(isPalindrome(listOf(1, 2, 1)), true)
assertEquals(isPalindrome(listOf(1, 2, 2, 1)), true)

//Pruebas personales
assertEquals(isPalindrome(listOf(1, 2, 3, 1)), false)
assertEquals(isPalindrome(listOf(5,5,5,5,5,5,5)), true)
assertEquals(isPalindrome(listOf(1,2,1,2,1,2,1)), true)
assertEquals(isPalindrome(listOf(1,2,3,4,5,4,3,2,1)), true)


// P07

//Pruebas de GITHUB
assertEquals(315.primeFactorMultiplicity() == listOf(Pair(3, 2), Pair(5, 1), Pair(7, 1)), true)

//Pruebas personales
assertEquals(315.primeFactorMultiplicity() == listOf(Pair(1, 2), Pair(5, 1), Pair(7, 1)), false)
assertEquals(12.primeFactorMultiplicity() == listOf(Pair(2, 2), Pair(3, 1)), true)
assertEquals(7.primeFactorMultiplicity() == listOf(Pair(7, 1)), true)
