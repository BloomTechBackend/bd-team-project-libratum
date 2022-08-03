package models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import models.converter.ConverterForUser;
import models.converter.ListConverterForPost;
import models.converter.ListConverterForWine;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@DynamoDBTable(tableName = "user")

public class Users {

    @DynamoDBHashKey(attributeName = "user_name")
    private String username;

    @DynamoDBAttribute(attributeName = "user_id")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    private String password;
    @DynamoDBAttribute
    private UserType type;
    @DynamoDBAttribute
    private String bio;
    @DynamoDBAttribute
    private List<Post> posts;
    @DynamoDBAttribute
    private List<Wine> favorites;


    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        this.type = UserType.USER;
        this.bio = "";
        this.posts = new ArrayList<>();
        favorites = new ArrayList<>();
    }




    @DynamoDBAttribute(attributeName = "user_id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id ;
    }

    public void setId(String id) {
        this.id = id;
    }



    @DynamoDBAttribute
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = ListConverterForWine.class)
    public List<Wine> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<Wine> favorites) {
        this.favorites = favorites;
    }

    public boolean addToFavorites(Wine wine) {
      return favorites.add(wine);
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setType(UserType type) {
        this.type = type;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }


    public String getUsername() {
        return this.username;
    }

    @DynamoDBAttribute
    public String getPassword() {
        return this.password;
    }

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    public UserType getType() {
        return this.type;
    }
    public String getBio() {
        return this.bio;
    }

    @Override
    public String toString() {
        return "Users {" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", bio='" + bio + '\'' +
                ", posts=" + posts +
                ", favorites=" + favorites +
                '}';
    }

    public String toJSObject() {
        return '{' +
                    "id:" + id +
                    ", username:'" + username + '\'' +
                    ", password:'" + password + '\'' +
                    ", type:" + type +
                    ", bio:'" + bio + '\'' +
                    ", posts:" + posts +
                    ", favorites:" + favorites +
                '}';
    }


    @Override
    public boolean equals(Object that) {
        if(that == null) {
            return false;
        }

        if(!(that instanceof Users)) {
            return false;
        }

        Users otherUser = (Users) that;

        if(!this.username.equals(otherUser.username)) {
            return false;
        }

        if(!this.password.equals(otherUser.password)) {
            return false;
        }

        return true;
    }
}
