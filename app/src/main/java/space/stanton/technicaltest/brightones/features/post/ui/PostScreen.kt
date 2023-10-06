package space.stanton.technicaltest.brightones.features.post.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import space.stanton.technicaltest.brightones.features.post.data.model.Post
import space.stanton.technicaltest.brightones.features.post.viewmodel.PostViewModel

@Composable
fun PostScreen(modifier: Modifier = Modifier,postViewModel: PostViewModel = hiltViewModel()) {

    val posts = postViewModel.posts.value.posts

    if (posts != null) {
        PostView(
            modifier = modifier,
            posts = posts,
            postViewModel = postViewModel,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostView(
    modifier: Modifier,
    posts: List<Post>,
    postViewModel: PostViewModel,
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar("Post List")
        }
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
        ) {
            LazyColumn {
                items(posts) {
                    posts.filter { it.body != null }.sortedBy { it.id }.forEach {
                        PostView(post = it, postViewModel = postViewModel)
                        Divider(modifier = Modifier.padding(top = 8.dp, bottom = 16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun PostView(post: Post, postViewModel: PostViewModel) {

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .clickable {
                postViewModel.navigateToDetail()
            }
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = post.title,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )
        post.body?.let {
            Text(text = it, fontSize = 14.sp)
        }
    }
}