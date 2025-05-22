package com.agq.java.ai.langchain4j;

import com.agq.java.ai.langchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
public class MongoCrudTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testInsert() {
       //mongoTemplate.insert(new ChatMessage(1L,"聊天记录"));
    }
    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录列表");
        mongoTemplate.insert(chatMessages);
    }
    @Test
    public void testFindById() {
        ChatMessages chatMessages = mongoTemplate.findById("682c7ec65b08111ba996073e", ChatMessages.class);
        System.out.println(chatMessages);
    }

    @Test
    public  void testUpdate() {
        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "更新后的聊天记录");
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }
    @Test
    public void testUpdate2() {
        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "更新后的聊天记录");
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }
    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("_id").is("682c7ec65b08111ba996073e");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
