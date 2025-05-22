package com.agq.java.ai.langchain4j.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//表示这是一个MongoDB文档
@Data
//表示这个类是一个数据传输对象（DTO），用于在应用程序中传递数据
@AllArgsConstructor
//表示这个类是一个无参构造函数
@NoArgsConstructor
//表示这个类是一个MongoDB文档，文档的名称为"chat_messages"
@Document("chat_messages")
public class ChatMessages {
    //唯一标识，映射到MongoDB文档的_id字段
    @Id
    private ObjectId messageId;
    //存储当前聊天
    private int memoryId;
    //存储当前聊天记录的json字符串
    private String content;
}
