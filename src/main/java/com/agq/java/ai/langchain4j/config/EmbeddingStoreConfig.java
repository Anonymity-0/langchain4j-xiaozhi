package com.agq.java.ai.langchain4j.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.pinecone.PineconeEmbeddingStore;
import dev.langchain4j.store.embedding.pinecone.PineconeServerlessIndexConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static dev.langchain4j.internal.Utils.randomUUID;

@Configuration
public class EmbeddingStoreConfig {
    @Autowired
    private EmbeddingModel embeddingModel;
    @Value("${pinecone.api-key}")
    private String pineconeApiKey;
    @Bean
    public EmbeddingStore<TextSegment> embeddingStore() {
//创建向量存储
        //如果指定的索引不存在，将创建一个新的索引
        //如果指定的名称空间不存在，将创建一个新的名称 空间
        //指定索引部署在 AWS 云服务上。
        //指定索引所在的 AWS 区域为 us-east-1。

        return  PineconeEmbeddingStore.builder()
                .apiKey(pineconeApiKey)
                .index("xiaozhi-index")
                .nameSpace("xiaozhi-namespace")
                .createIndex(PineconeServerlessIndexConfig.builder()
                        .cloud("AWS")
                        .region("us-east-1")
                        .dimension(embeddingModel.dimension())
                        .build())
                .build();
    }
} //指定索引的向量维度，该维度与 embeddedModel 生成的向量维度相同。

