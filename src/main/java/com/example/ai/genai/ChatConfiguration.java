/*
 * Copyright 2012-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ai.genai;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.DEFAULT_CHAT_MEMORY_CONVERSATION_ID;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.example.ai.service.PostService;

@Configuration
class ChatConfiguration
{

    @Value("classpath:/prompts/system.st")
    private Resource systemResource;

    @Autowired
    private PostService postService;

    @Bean
    ChatClient chatClient(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory)
    {
        // @formatter:off
        return chatClientBuilder
            .defaultAdvisors(
                // Chat memory helps us keep context when using the chatbot for up to 10 previous messages.
                new MessageChatMemoryAdvisor(chatMemory, DEFAULT_CHAT_MEMORY_CONVERSATION_ID, 10), // CHAT MEMORY
                new SimpleLoggerAdvisor()
            )
            .defaultSystem(systemResource)
            .defaultTools(postService)
            //.defaultFunctions("getTestSuites", "getStrackTraceOverview")
            .build();
        // @formatter:on
    }
    // @Bean
    // ChatClient chatClient(ChatModel chatModel)
    // {// , SyncMcpToolCallbackProvider myCallbackProvider) {
    // return ChatClient.builder(chatModel)
    // //.defaultSystem(systemResource)
    // // .defaultFunctions("getTestSuites", "getStrackTraceOverview")
    // // .defaultTools(myCallbackProvider.getToolCallbacks())
    // //.defaultTools(isteAiDataProvider)
    // .build();
    // }

    // @Bean
    // ToolCallbackProvider myCallbackProvider()
    // {
    // return MethodToolCallbackProvider.builder().toolObjects(isteAiDataProvider).build();
    // }

    @Bean
    ChatMemory chatMemory()
    {
        return new InMemoryChatMemory();
    }

}
