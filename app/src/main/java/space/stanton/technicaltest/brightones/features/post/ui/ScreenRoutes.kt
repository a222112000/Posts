package space.stanton.technicaltest.brightones.features.post.ui

sealed class ScreenRoutes(val route: String) {
    object Posts: ScreenRoutes("posts")
}