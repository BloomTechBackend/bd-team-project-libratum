package models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
@DynamoDBTable(tableName = "post")
public class Post {

    @DynamoDBAutoGeneratedKey
    private String id;

    private String postThreadId;

    private Users fromUser;

    private String content;

    private Date date;

    private Integer likes;

    public Post(Users fromUser) {
        this.fromUser = fromUser;
    }



    public Post() {
    }

    public Post(String postThreadId, Users fromUser, String content, Date date, int likes) {

        this.postThreadId = postThreadId;
        this.fromUser = fromUser;
        this.content = content;
        this.date = date;
        this.likes = likes;
    }

    @DynamoDBHashKey(attributeName = "user_id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @DynamoDBAttribute
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    public String getPostThreadId() {
        return this.postThreadId;
    }

    public void setPostThread(String postThreadId) {
        this.postThreadId = postThreadId;
    }


    @DynamoDBAttribute
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    public Users getFromUser() {
        return fromUser;
    }

    public void setFromUser(Users fromUser) {
        this.fromUser = fromUser;
    }


    @DynamoDBAttribute
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @DynamoDBAttribute
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @DynamoDBAttribute
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void reply(Post post) {
        post.postThreadId = this.postThreadId;
        //this.fromUser.getPosts().add(post);
    }


}
