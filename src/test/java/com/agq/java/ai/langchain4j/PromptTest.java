package com.agq.java.ai.langchain4j;

import com.agq.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.agq.java.ai.langchain4j.assistant.SeparateChatAssistant;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testSystemMessage() {
        String answer = separateChatAssistant.chat(4,"今天几号");
        System.out.println(answer);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testUserMessage() {
        String answer = memoryChatAssistant.chat("我是ag");
        System.out.println(answer);

        String answer2 = memoryChatAssistant.chat("今年18");
        System.out.println(answer2);

        String answer3 = memoryChatAssistant.chat("你知道我是谁吗，几岁了");
        System.out.println(answer3);
    }

    @Test
    public void testV() {

        String answer = separateChatAssistant.chat2(5,"我是ag");
        System.out.println(answer);

        String answer2 = separateChatAssistant.chat2(5,"今年18");
        System.out.println(answer2);

        String answer3 = separateChatAssistant.chat2(5,"你知道我是谁吗，几岁了");
        System.out.println(answer3);
    }

    @Test
    public void testUserInfo() {
        String answer = separateChatAssistant.chat3(6, "我是谁，我多大了", "翠花", 18);
        System.out.println(answer);
    }
}
