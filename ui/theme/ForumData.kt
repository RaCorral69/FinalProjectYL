package com.example.finalprojectyl.ui.theme

class ForumData {
    data class Post(
        val id: String,
        val title: String,
        val content: String,
        val author: String,
        val timestamp: Long,
        val comments: List<Comment>
    )

    data class Comment(
        val id: String,
        val postId: String,
        val content: String,
        val author: String,
        val timestamp: Long
    )

}