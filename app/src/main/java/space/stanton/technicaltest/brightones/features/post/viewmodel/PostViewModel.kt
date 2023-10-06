package space.stanton.technicaltest.brightones.features.post.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import space.stanton.technicaltest.brightones.features.post.data.model.Post
import space.stanton.technicaltest.brightones.features.post.data.repository.PostRepository
import space.stanton.technicaltest.brightones.features.post.domain.PostsUseCase
import space.stanton.technicaltest.brightones.features.post.utils.PostResources
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val getPostsUseCase: PostsUseCase): ViewModel() {

   // private val postRepository = PostRepository()

   // var posts = MutableStateFlow<List<Post>>(emptyList())
    private val _posts = mutableStateOf(PostsState())
    val posts : State<PostsState> = _posts

//    fun loadPost() {
//        viewModelScope.launch {
//            val result = postRepository.retrieveAllPosts()
//            posts.emit(result.shuffled())
//        }
//    }

    init {
        loadPost()
    }

    private fun loadPost(){
        getPostsUseCase().onEach { posts->
            when(posts){
                is PostResources.Error -> {
                    _posts.value = PostsState(error = posts.message ?: "Error Occur")
                }
                is PostResources.Loading -> {
                    _posts.value = PostsState(isLoading = true)
                }
                is PostResources.Success -> {
                    _posts.value = PostsState(posts = posts.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun navigateToDetail() {
        // TODO: For you to implement however you see fit.
    }
}