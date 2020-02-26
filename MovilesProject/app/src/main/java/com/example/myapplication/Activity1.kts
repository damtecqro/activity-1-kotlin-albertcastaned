package com.example.myapplication


/* ACTIVITY 1
* AUTHOR: Alberto Castañeda Arana A01250546
* PROBLEMS SOLVED: P6, P36
*/


fun isPalindrome(nums: List<Int>) : Boolean
{
    /* PSEUDOCODE
    * PROCEDURE(List of ints)
    * lowIndex = 0
    * highIndex = nums.size - 1
    * mid = highIndex / 2
    
    *for each numher in nums
        * if lowIndex > mid
            * exit loop
        * if nums[lowIndex] != nums[highIndex])
            * return false
        
        * highIndex -= 1
        * lowIndex += 1
    
    *return true
    */
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
    
    /* PSEUDOCODe
        * PROCEDURE isPrime(num)
        * if num <= 1
            * return false
        * i = 2
        * while i < num
            * if num % i == 0
                * return false
            * i += 1
        * return true
    */
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
    /* PSEUDOCODE
        * PROCEDURE primeFactors(num)
        * if num is prime
            * return list of only num
        * aux = Initialize List of sequence 2,3,4 .... num/2
        * aux = filter only prime numbers
        * primeFactor = find first factor of num in list aux
        * if prime is null
            * return empty List
        * else 
            * return List of primeFactor + primeFactors( num / primeFactor )
        * return true
    */
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
    /* PSEUDOCODE
        * PROCEDURE primeFactorMultiplicity(num)
            * primeFactors = List of prime factors of num
            * Sort primeFactors
            * return List of Pairs ( factor, number of times the factor appears on the list) 
    */
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

//GITHUB Test Cases
assertEquals(isPalindrome(listOf<Int>()), true)
assertEquals(isPalindrome(listOf(1)), true)
assertEquals(isPalindrome(listOf(1, 2)), false)
assertEquals(isPalindrome(listOf(1, 2, 1)), true)
assertEquals(isPalindrome(listOf(1, 2, 2, 1)), true)

//PERSONAL Test Cases
assertEquals(isPalindrome(listOf(1, 2, 3, 1)), false)
assertEquals(isPalindrome(listOf(5,5,5,5,5,5,5)), true)
assertEquals(isPalindrome(listOf(1,2,1,2,1,2,1)), true)
assertEquals(isPalindrome(listOf(1,2,3,4,5,4,3,2,1)), true)


// P07

//GITHUB Test Cases
assertEquals(315.primeFactorMultiplicity() == listOf(Pair(3, 2), Pair(5, 1), Pair(7, 1)), true)

//PERSONAL Test Cases
assertEquals(315.primeFactorMultiplicity() == listOf(Pair(1, 2), Pair(5, 1), Pair(7, 1)), false)
assertEquals(12.primeFactorMultiplicity() == listOf(Pair(2, 2), Pair(3, 1)), true)
assertEquals(7.primeFactorMultiplicity() == listOf(Pair(7, 1)), true)
