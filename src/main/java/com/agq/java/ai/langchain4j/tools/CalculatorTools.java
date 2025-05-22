package com.agq.java.ai.langchain4j.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {

    @Tool(name = "加法运算",value = "将两个参数a和b相加并返回运算结果")
    double sum(
            @ToolMemoryId long memoryId,
            @P(value="加数1", required = true) double a,
            @P(value="加数2", required = true) double b) {
        System.out.println(memoryId+"调用加法运算");
        return a + b;
    }

    @Tool(name = "平方根运算",value = "计算给定参数的平方根")
    double squareRoot(@ToolMemoryId long memoryId, double x) {
        System.out.println(memoryId+"调用平方根运算");
        return Math.sqrt(x);
    }
}
