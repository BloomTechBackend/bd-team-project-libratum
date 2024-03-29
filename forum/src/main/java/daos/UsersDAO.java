package daos;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import libratum.unit5.forum.ForumApplication;
import models.Users;
import models.converter.ConverterForUser;
import models.converter.ListConverterForPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UsersDAO {

    private final DynamoDBMapper dynamoDBMapper;

    public UsersDAO(AmazonDynamoDB db) {
        this.dynamoDBMapper = new DynamoDBMapper(db);
    }


    // Create
    //@DynamoDBTypeConverted(converter = ConverterForUser.class)
    public Users saveUser(Users user) {
        dynamoDBMapper.save(user);
        return user;
    }

    // Read

    public Users findByUsername(String username) {

        return dynamoDBMapper.load(Users.class, username);
    }

    public List<Users> findALL() {
        return dynamoDBMapper.scan(Users.class, new DynamoDBScanExpression());
    }

    // Update

    /**
     * Might be unsafe.
     * @param id - user_id
     * @param user - the user
     * @return status update
     */
    public String update(String id, Users user) {
        dynamoDBMapper.save(user, new DynamoDBSaveExpression()
                .withExpectedEntry("id",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(id)
                        )));
        return "User was updated";
    }


    // Delete

    public String delete(String id) {
        Users user = dynamoDBMapper.load(Users.class, id);
        dynamoDBMapper.delete(user);

        return "Deleted user: " + id;
    }

}

