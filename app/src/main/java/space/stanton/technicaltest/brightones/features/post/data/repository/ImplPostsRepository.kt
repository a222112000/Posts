package space.stanton.technicaltest.brightones.features.post.data.repository

import space.stanton.technicaltest.brightones.features.post.data.model.Post
import space.stanton.technicaltest.brightones.features.post.domain.PostsRepository
import javax.inject.Inject

class ImplPostsRepository @Inject constructor(private val api: PostService): PostsRepository {
    override suspend fun getPosts(): List<Post> {
        return api.retrieveAllPosts()
    }
}