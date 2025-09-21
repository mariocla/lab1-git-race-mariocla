package es.unizar.webeng.hello.services

import java.time.LocalTime

class TimeGreetingService {

    
    /**
     * Returns a greeting message based on the current time of day.
     *
     * @param name The name to include in the greeting.
     * @return A personalized greeting message appropriate for the current time.
     */
    fun getGreeting(name: String): String {
        val currentHour = LocalTime.now().hour // Get the current hour (0-23)
        return when (currentHour) {
            in 5..11 -> "Good morning, $name!"
            in 12..17 -> "Good afternoon, $name!"
            else -> "Good evening, $name!"
        }
    }
}