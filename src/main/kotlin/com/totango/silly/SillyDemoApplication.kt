package com.totango.silly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SillyDemoApplication

fun main(args: Array<String>) {
	runApplication<SillyDemoApplication>(*args)
}
