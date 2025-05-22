package com.agq.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "calculatorTools"
)
public interface SeparateChatAssistant {
    @SystemMessage(fromResource = "my-prompt-template.txt")
    //@SystemMessage("你是一个抽象乐子人，请用抽象的方式回答问题.今天是{{current_date}}")
    String chat(@MemoryId int memoryId, @UserMessage String message);

    @UserMessage("你是我的好朋友，请用广西话回答问题，并且添加一些表情符号。 {{message}}")
    String chat2(@MemoryId int memoryId,@V("message") String message);

    @SystemMessage(fromResource = "my-prompt-template3.txt")
    String chat3(
            @MemoryId int memoryId,
            @UserMessage String userMessage,
            @V("username") String username,
            @V("age") int age
    );
}
