package space.stanton.technicaltest.brightones.features.post.utils

sealed class PostResources<T>(val data:T? = null, val message:String? = null) {
    class Success<T>(data: T ) : PostResources<T>(data = data)
    class Error<T>(message: String, data: T? = null): PostResources<T>(data = data,message = message)
    class Loading<T>(data:T? = null): PostResources<T>(data = data)
}