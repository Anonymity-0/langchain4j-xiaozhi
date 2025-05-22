package com.agq.java.ai.langchain4j.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * MemoryChatAssistant interface for chat with memory.
 * 初级智能体，含有记忆功能
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {
    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{message}}")
    String chat(@V("message") String message);
}
