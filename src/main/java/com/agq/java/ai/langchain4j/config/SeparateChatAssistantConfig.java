package com.agq.java.ai.langchain4j.config;

import com.agq.java.ai.langchain4j.store.MongoChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeparateChatAssistantConfig {
    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;
    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        // 创建一个id为"memoryId"的MessageWindowChatMemory实例，使用到lambda表达式，最大消息数为10
        //memoryId - 这是Lambda表达式的输入参数，代表每个对话的唯一标识符。在SeparateChatAssistant接口中，这个标识符是以@MemoryId int memoryId的形式传入的
        return memoryId->MessageWindowChatMemory
                .builder()
                .id(memoryId)
                .maxMessages(10)
                // 创建一个InMemoryChatMemoryStore实例,他本质上是一个内存存储器，用于存储聊天记录
                //.chatMemoryStore(new InMemoryChatMemoryStore())
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }
}
