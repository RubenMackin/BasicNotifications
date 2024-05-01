package com.rubenmackin.basicnotifications

import androidx.lifecycle.ViewModel
import com.rubenmackin.basicnotifications.data.TopicsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val topicsService: TopicsService) : ViewModel() {
    fun subscribeToTopic(topic: String) {
        topicsService.suscribeToTopic(topic)
    }
}