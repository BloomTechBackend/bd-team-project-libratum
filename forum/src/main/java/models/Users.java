package models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
@DynamoDBTable(tableName = "user")
public class Users {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private int id;
    @DynamoDBAttribute
    private String username;
    @DynamoDBAttribute
    private String password;
    @DynamoDBAttribute
    private UserType type;
    @DynamoDBAttribute
    private String bio;
    @DynamoDBAttribute
    private ArrayList<Post> posts;
    @DynamoDBAttribute
    private LinkedList<Wine> favorites;

    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        this.type = UserType.USER;
        this.bio = "";
        posts = new ArrayList<>();
        favorites = new LinkedList<>();

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

    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
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
}
