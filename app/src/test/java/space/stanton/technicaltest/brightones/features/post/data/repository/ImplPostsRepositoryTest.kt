package space.stanton.technicaltest.brightones.features.post.data.repository

import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import space.stanton.technicaltest.brightones.features.post.data.model.Post

class ImplPostsRepositoryTest {

    @MockK
    private lateinit var implPostsRepository: ImplPostsRepository
    @MockK
    private val postService = mockk<PostService>()

    @Before
    fun setUp() {
        implPostsRepository = ImplPostsRepository(postService)
    }

    @Test
    fun getPostsTest() = runBlocking {

        val posts = retrieveAllPosts()
        assertEquals(2, posts.size)
    }

    suspend fun retrieveAllPosts(): List<Post> {
        return listOf(
            Post(1, 1, "Post 1", "Body 1"),
            Post(2, 1, "Post 2", "Body 2")
        )
    }

    @Test
    fun testGetPosts() = runBlocking {

        // Set up a fake response for retrieveAllPosts
        val fakePosts = listOf(
            Post(1, 1,"Title 1", "Body 1"),
            Post(2, 1,"Title 2", "Body 2")
        )
        coEvery { postService.retrieveAllPosts() } returns fakePosts

        // Call the function you want to test
        val result = implPostsRepository.getPosts()

        // Perform assertions on the result
        assertEquals(2, result.size)
        assertEquals("Title 1", result[0].title)
        assertEquals("Body 2", result[1].body)
    }
}