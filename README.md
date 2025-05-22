# 智能助手应用 - 基于 Langchain4j

这是一个基于 Java 和 Langchain4j 框架开发的智能助手应用项目，集成了多种大语言模型能力，提供了智能问答、知识检索、智能工具调用等功能。

## 项目介绍

本项目是一个智能助手系统，名为"小智"，通过集成 Langchain4j 框架实现了以下功能：

- 基础的智能对话功能
- 支持流式响应的聊天模式
- 知识库检索增强生成（RAG）能力
- 嵌入模型的向量化计算
- 会话记忆功能
- 工具调用能力
- 数据库集成与持久化

## 技术栈

- **后端**：Spring Boot + Java
- **大模型框架**：Langchain4j
- **模型供应商**：DashScope (通义千问系列)、OpenAI
- **数据库**：MongoDB (会话记忆存储)、MySQL
- **前端**：Vue.js

## 项目配置

### 必要配置项

项目运行需要配置以下关键参数：

1. **DashScope API Keys**：通义千问系列模型的访问密钥
2. **数据库连接信息**：MongoDB 和 MySQL 的连接配置

### 配置文件

本项目使用 Spring Boot 的配置机制，主要配置文件包括：
- `application.properties`: 主配置文件
- `application.yml`: YAML 格式的配置文件
- `application-local.yml`: 本地环境特定配置（不提交到代码库）

### 环境变量配置方式

为保护敏感信息（如 API Keys），建议使用环境变量方式配置以下参数：

```properties
# DashScope API Key
DASHSCOPE_API_KEY=your_dashscope_api_key

# 数据库配置（可选）
MYSQL_USERNAME=your_mysql_username
MYSQL_PASSWORD=your_mysql_password
```

## 快速开始

### 环境要求

- JDK 17 或以上
- Maven 3.6 或以上
- MongoDB 4.x
- MySQL 8.x
- Node.js 16+ (前端部分)

### 后端启���步骤

1. 克隆项目到本地
   ```bash
   git clone https://your-repository-url/java-ai-langchain4j.git
   cd java-ai-langchain4j
   ```

2. 配置本地环境
   - 复制 `application-local.yml.template` 为 `application-local.yml`
   - 填入您的 API Keys 和其他敏感配置

3. 构建并运行项目
   ```bash
   mvn clean package
   java -jar target/java-ai-langchain4j-0.0.1-SNAPSHOT.jar
   ```

### 前端启动步骤

1. 进入前端目录
   ```bash
   cd xiaozhi-ui
   ```

2. 安装依赖并启动开发服务器
   ```bash
   npm install
   npm run dev
   ```

3. 访问应用
   ```
   http://localhost:5173
   ```

## 项目结构

```
src/
├── main/
│   ├── java/com/agq/java/ai/langchain4j/
│   │   ├── XiaoZhiApplication.java      # 应用程序入口
│   │   ├── assistant/                   # 助手相关功能
│   │   ├── bean/                        # JavaBean定义
│   │   ├── config/                      # 配置类
│   │   ├── controller/                  # Web控制器
│   │   ├── entity/                      # 实体类
│   │   ├── mapper/                      # MyBatis映射器
│   │   ├── service/                     # 业务逻辑服务
│   │   ├── store/                       # 存储相关功能
│   │   └── tools/                       # 工具类
│   │
│   └── resources/                       # 资源文件
│       ├── application.properties       # 主配置文件
│       ├── application.yml              # YAML配置
│       └── mapper/                      # MyBatis XML映射文件
│
└── test/                                # 测试代码目录
    └── java/com/agq/java/ai/langchain4j/
        ├── AIServiceTest.java           # AI服务测试
        ├── ChatMemoryTest.java          # 会话记忆测试
        ├── EmbeddingTest.java           # 嵌入模型测试
        └── ...                          # 其他测试类

xiaozhi-ui/                              # 前端Vue项目目录
```

## API 参考

项目提供的主要API接口：

- `/api/chat`: 聊天对话接口
- `/api/stream-chat`: 流式聊天接口
- `/api/tools`: 工具调用接口
- `/api/appointment`: 预约管理接口

## 功能演示

1. **智能问答**: 系统可回答用户提问，支持多轮对话
2. **知识检索**: 通过向量数据库实现对特定领域知识的精准检索
3. **工具调用**: 支持日历查询、信息检索等工具使用
4. **智能预约**: 提供智能预约管理功能

## 如何贡献

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/amazing-feature`)
3. 提交更改 (`git commit -m 'Add some amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 开启一个 Pull Request

## 注意事项

- 不要将含有敏感信息的配置文件提交到Git仓库
- 建议使用环境变量或本地配置文件管理API密钥等敏感信息
- 确保 `application-local.yml` 已加入 `.gitignore` 文件

## 许可证

[填写您的许可证信息]

## 联系方式

[填写您的联系方式]
