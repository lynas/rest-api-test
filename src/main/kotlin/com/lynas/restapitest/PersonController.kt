package com.lynas.restapitest

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/persons")
class PersonController {


    private final val p1 = Person(1, "Alex", 14)
    private final val p2 = Person(2, "Max", 16)
    private final val p3 = Person(3, "Cathy", 22)
    private final val p4 = Person(4, "Clark", 25)
    private final val p5 = Person(5, "Smith", 15)
    val listOfPersons = mutableListOf(p1, p2, p3, p4, p5)

    @GetMapping
    fun personList(): List<Person> {

        return listOfPersons
    }

    @GetMapping("/{id}")
    fun person(@PathVariable id: Int): Person {
        return when (id) {
            1 -> p1
            2 -> p2
            3 -> p3
            4 -> p4
            5 -> p5
            else -> throw NullPointerException("person not available")
        }
    }

    @PostMapping
    fun personPost(@RequestBody person: Person) : Person {
        listOfPersons.add(person)
        return person
    }

    @PatchMapping("/{id}")
    fun personUpdate(@PathVariable id: Int, @RequestBody person: Person) : Person {
        listOfPersons[id] = person
        return person
    }


    @DeleteMapping("/{id}")
    fun personDelete(@PathVariable id: Int) : List<Person> {
        listOfPersons.removeAt(id)
        return listOfPersons
    }



}


class Person(val id:Int, val name:String, val age:Int)