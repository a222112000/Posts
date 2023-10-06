package space.stanton.technicaltest.brightones.features.post.domain

import space.stanton.technicaltest.brightones.features.post.data.model.Post

interface PostsRepository {

    suspend fun getPosts():List<Post>
}