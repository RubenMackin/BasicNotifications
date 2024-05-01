package com.rubenmackin.basicnotifications.data

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject

class TopicsService @Inject constructor(private val messagingService: FirebaseMessaging) {

    companion object {
        const val FOOTBALL_TOPIC = "football_topic"
        const val BASKETBALL_TOPIC = "basketball_topic"
        const val PETANCA_TOPIC = "petanca_topic"
    }

    fun suscribeToTopic(topic: String) {
        messagingService.subscribeToTopic(topic).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.i("RubenDevs", "Suscrito al topic $topic")
            } else {
                Log.i("RubenDevs", "Error en el topic $topic")
            }
        }
    }

    fun unsuscribeToTopic(topic: String) {
        messagingService.unsubscribeFromTopic(topic)
    }
}