package com.agq.java.ai.langchain4j;

import com.agq.java.ai.langchain4j.assistant.Assistant;
import com.agq.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.agq.java.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.service.AiServices;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class ChatMemoryTest {
    @Autowired
    private Assistant assistant;

    @Test
    public void testChatMemory() {
        String answer1 = assistant.chat("我是qq");
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁");
        System.out.println(answer2);
    }

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChatMemory2() {
        // 第一轮对话
        UserMessage userMessage1 = UserMessage.from("我是环环");  // 使用from方法替代不存在的userMessage方法
        Response<AiMessage> chatResponse1 = qwenChatModel.generate(userMessage1);
        AiMessage aiMessage1 = chatResponse1.content();  // 使用content()方法获取AiMessage
// 输出大语言模型的回复
        System.out.println(aiMessage1.text());

// 第二轮对话
        UserMessage userMessage2 = UserMessage.from("你知道我是谁吗");  // 同样使用from方法
// 使用generate方法而不是chat，并传入消息列表
        Response<AiMessage> chatResponse2 = qwenChatModel.generate(
                List.of(userMessage1, aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.content();  // 使用content()获取AiMessage
// 输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }

    @Test
    public void testChatMemory3() {
        // 设置记忆存储的最长长度
        MessageWindowChatMemory messageWindowChatMemory = MessageWindowChatMemory.withMaxMessages(10);
        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(messageWindowChatMemory)
                .build();
        System.out.println(assistant.chat("我是aga"));
        System.out.println(assistant.chat("我是谁"));
    }

    @Autowired
    private MemoryChatAssistant chatAssistant;
    @Test
    public void testChatMemory4() {
        // 设置记忆存储的最长长度

        System.out.println(chatAssistant.chat("我是aga"));
        System.out.println(chatAssistant.chat("我是谁"));
    }
    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory5() {
        // 设置记忆存储的最长长度

        System.out.println(separateChatAssistant.chat(1,"我是aga"));
        System.out.println(separateChatAssistant.chat(1,"我是谁"));
        System.out.println(separateChatAssistant.chat(2,"我是谁"));
        System.out.println(separateChatAssistant.chat(2,"我是ag"));
        System.out.println(separateChatAssistant.chat(2,"我是谁"));
    }

}


