package space.stanton.technicaltest.brightones.features.post.viewmodel

import space.stanton.technicaltest.brightones.features.post.data.model.Post

data class PostsState(
    val isLoading: Boolean = false,
    var posts: List<Post>? = emptyList(),
    val error: String = ""
)
