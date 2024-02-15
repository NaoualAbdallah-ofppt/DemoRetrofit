package aa.bb.demoretrofit;


import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @GET("posts")
    Call<List<Post>> listePosts();
@GET("photos")
    Call<List<Photo>> getListePhotos();


    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int idPost);
   /*
    @GET("comments/{id}")
    Call<Comment> recupererComment(@Path("id") int idC );
   */
    /*
     @GET("comments")
    Call<List<Comment>> getCommentsByPostId(@Query("postId") int postId);

           @GET("posts/{id}/comments")
        Call<List<Comment>> getCommentsById(@Path("id") int postId);

    */
    /*
    @POST("posts")
    Call<Post> createPost(@Body Post post);
*/


}
