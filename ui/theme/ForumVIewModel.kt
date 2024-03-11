package com.example.finalprojectyl.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForumViewModel : ViewModel() {
    // LiveData to hold the list of posts
    val posts: LiveData<List<ForumData.Post>> = MutableLiveData()

    // Function to fetch posts from the backend
    fun fetchPosts() {
        // Implement fetching posts from the backend here
    }
}
