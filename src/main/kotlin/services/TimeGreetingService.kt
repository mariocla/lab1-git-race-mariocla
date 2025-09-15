package es.unizar.webeng.hello.services

import java.time.LocalTime

class TimeGreetingService {
    fun getGreeting(name: String): String {
        val currentHour = LocalTime.now().hour
        return when (currentHour) {
            in 5..11 -> "Good morning, $name!"
            in 12..17 -> "Good afternoon, $name!"
            else -> "Good evening, $name!"
        }
    }
}