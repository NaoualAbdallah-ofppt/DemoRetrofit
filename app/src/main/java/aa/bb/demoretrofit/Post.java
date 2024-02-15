package aa.bb.demoretrofit;


public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
    /*@SerializedName("body") //le nom dans le retour json est body
    private String text ;

     */

    public int getUserId() {
        return userId;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", text='" + body + '\'' +
                '}';
    }
}
