package com.agq.java.ai.langchain4j;


import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageType;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class LLMTest {

    @Test
    public void testGPTDemo(){
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();

        String answer = model.chat("你是谁呀");
        System.out.println("answer : " + answer);
    }
    @Autowired
    public OpenAiChatModel openAiChatModel;
    @Test
    public void testSpringBoot(){
        String chat = openAiChatModel.chat("猜猜我是谁");
        System.out.println(chat);
    }

    /**
     * 通义千问大模型
     */
    @Autowired
    private QwenChatModel qwenChatModel;
    @Test
    public void testDashScopeQwen() {
        List<ChatMessage> messages = new ArrayList<>();
        UserMessage userMessage = UserMessage.from("你好");
        messages.add(userMessage);
        Response<AiMessage> messageResponse = qwenChatModel.generate(messages);
        System.out.println(messageResponse.toString());
        //向模型提问
        //String answer = String.valueOf(qwenChatModel.generate(messages));

        //输出结果
        //System.out.println(answer);
    }
}
