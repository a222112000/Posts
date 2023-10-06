package space.stanton.technicaltest.brightones.features.post.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import space.stanton.technicaltest.brightones.features.post.data.model.Post
import space.stanton.technicaltest.brightones.features.post.utils.PostResources
import javax.inject.Inject

class PostsUseCase @Inject constructor(private val repository: PostsRepository) {
    operator fun invoke(): Flow<PostResources<List<Post>>> = flow {
        try {
            emit(PostResources.Loading())
            val posts = repository.getPosts()
            emit(PostResources.Success(posts))
        }catch (e: Exception){
            emit(PostResources.Error(e.localizedMessage ?: "Something went wrong"))
        }
    }
}